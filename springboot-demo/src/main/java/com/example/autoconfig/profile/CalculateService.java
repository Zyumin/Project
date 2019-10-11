package com.example.autoconfig.profile;

/**
 * 求和服务
 * @see Java7CalculateService
 * @see Java8CalculateService
 *
 * @author zhengyumin
 * @create 2019-01-04 8:17 PM
 */

public interface CalculateService {

    /**
     * 从多个整数 sum 求和
     * @param values 多个整数
     * @return sum 累加值
     */
    Integer sum(Integer... values);
}
