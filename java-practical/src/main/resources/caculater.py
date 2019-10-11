-- 单量
-- 金额

    sql="""
    set mapred.output.compress=true;
    set hive.exec.compress.output=true;
    set mapred.output.compression.codec=com.hadoop.compression.lzo.LzopCodec;
    set io.compression.codecs=com.hadoop.compression.lzo.LzopCodec;
    set mapred.job.priority=VERY_HIGH;

    use app;

    CREATE TABLE if not exists app.app_wxsq_recommend_general_alg_d
    (
        idate                           string                  comment '日期'
        ,channelid                      string                  comment '渠道id'
        ,bid                            string                  comment '业务类型'
        ,pool_id                        string                  comment '池子id'
        ,recpos                         string                  comment '推介位'
        ,platform_id                    string                  comment '算法平台id'
        ,algorithm_id                   string                  comment '算法id'
        ,experiment_id                  string                  comment '实验id'
        ,property                       string                  comment '置顶标识'

        ,item_num                       bigint                  comment '曝光item数'
        ,show_pv                        bigint                  comment '曝光次数'
        ,show_uv                        bigint                  comment '曝光人数'

        ,click_pv                       bigint                  comment '点击次数'
        ,click_uv                       bigint                  comment '点击人数'

        ,ct_valid_ord_user              bigint                  comment '当前页有效订单用户数'
        ,ct_valid_cord_num              bigint                  comment '当前页有效下单子订单数'
        ,ct_valid_after_prefr_amount    double                  comment '当前页有效下单优惠后金额'

        ,ref_valid_ord_user             bigint                  comment '关联页有效订单用户数'
        ,ref_valid_cord_num             bigint                  comment '关联页有效下单子订单数'
        ,ref_valid_after_prefr_amount   double                  comment '关联页有效下单优惠后金额'

        ,s1                             string                  comment '保留字段'
        ,s2                             string                  comment '保留字段'
        ,s3                             string                  comment '保留字段'
        ,s4                             string                  comment '保留字段'
        ,s5                             string                  comment '保留字段'
        ,s6                             string                  comment '保留字段'
    ) COMMENT ''
    PARTITIONED BY (dt string, bizname string)
    ROW FORMAT DELIMITED FIELDS TERMINATED BY '\t'
    stored as orc
    tblproperties ('orc.compress'='SNAPPY');

    insert overwrite table app.app_wxsq_recommend_general_alg_d partition (dt='""" + yesterday + """', bizname='""" + bizname + """')

select
	*
from
	(
		select
			coalesce(ct.dt, ref.dt, - 1) dt,
			nvl(ct_valid_ord_user, 0) ct_valid_ord_user,
			nvl(ct_valid_cord_num, 0) ct_valid_cord_num,
			nvl(ct_valid_after_prefr_amount, 0) ct_valid_after_prefr_amount,
			nvl(ref_valid_ord_user, 0) ref_valid_ord_user,
			nvl(ref_valid_cord_num, 0) ref_valid_cord_num,
			nvl(ref_valid_after_prefr_amount, 0) ref_valid_after_prefr_amount,
			coalesce(ct.sku_id, ref.sku_id, - 1) sku
		from
			(
				select
					dt,
					count(distinct visit_key) ct_valid_ord_user,
					count(distinct cdealid) ct_valid_cord_num,
					sum(after_prefr_amount) ct_valid_after_prefr_amount,
					sku_id
				from
					(
						select
							dt,
							visit_key,
							cdealid,
							after_prefr_amount,
							sku_id
						from
							(
								select
									dt,
									visit_key,
									cdealid,
									after_prefr_amount,
									row_number() over(partition by ct_pps['biz'], dealid order by request_tm desc) rn,
									sale_ord_valid_flag,
									sku_id
								from
									app.app_wechatqq_order_link_pv_total_midv6
								where
									dt = sysdate( - 2)
									and type = 1
									and kind = 'order'
									and ct_pps['biz'] = 'pinlike'
									and viewflag = 1
									and ct_pps['recpos_d'] = 5708
							)
							aaa
						where
							rn = 1
							and sale_ord_valid_flag = 1 ---有效订单
					)
					bbb
				group by
					sku_id,
					dt
			)
			ct
		inner join
			(
				select
					dt,
					count(distinct visit_key) ref_valid_ord_user,
					count(distinct cdealid) ref_valid_cord_num,
					sum(after_prefr_amount) ref_valid_after_prefr_amount,
					sku_id
				from
					(
						select
							dt,
							visit_key,
							cdealid,
							after_prefr_amount,
							sku_id
						from
							(
								select
									dt,
									visit_key,
									cdealid,
									after_prefr_amount,
									row_number() over(partition by ct_pps['biz'], dealid order by request_tm desc) rn,
									sale_ord_valid_flag,
									sku_id
								from
									app.app_wechatqq_order_link_pv_total_midv6
								where
									dt = sysdate( - 2)
									and type = 1
									and kind = 'order'
									and ref_pps['biz'] = 'pinlike'
									and viewflag = 1
									and ct_pps['recpos_d'] = 5708
							)
							ccc
						where
							rn = 1
							and sale_ord_valid_flag = 1 ---有效订单f
					)
					ddd
				group by
					sku_id,
					dt
			)
			ref
		on
			ct.dt = ref.dt
			and ct.sku_id = ref.sku_id
	)
	skuorder
left OUTER join
	(
		select
			pvuv.dt,
			pvuv.sku,
			property,
			case
				when property = 0
				then show_pv
				else 0
			end as show_pv,
			case
				when property = 0
				then show_uv
				else 0
			end as show_uv
		from
			(
				select
					dt,
					count( *) show_pv,
					count(distinct visitkey) show_uv,
					sku
				from
					gdm.gdm_wxsq_mcoss_pinlike_show2_d lateral view explode(split(item_id, ',')) s as sku
				where
					dt = sysdate( - 1)
					and recpos = 5708
				group by
					sku,
					dt
			)
			pvuv
		inner join
			(
				select
					dt,
					sku,
					case
						when cast(property1 as bigint) & 65536 = 65536
							or cast(property1 as bigint) & 1 = 1
						then 1
						else 0
					end as property
				from
					(
						select
							*
						from
							gdm.gdm_wxsq_mcoss_pinlike_show2_d lateral view explode(split(property, ',')) p as property1
					)
					pro lateral view explode(split(item_id, ',')) s1 as sku
				where
					dt = sysdate( - 1)
					and recpos = 5708
				group by
					sku,
					dt,
					case
						when cast(property1 as bigint) & 65536 = 65536
							or cast(property1 as bigint) & 1 = 1
						then 1
						else 0
					end
			)
			itemnum
		on
			pvuv.dt = itemnum.dt
			and pvuv.sku = itemnum.sku
	)
	skupvuv on skuorder.sku = skupvuv.sku

	"""