import org.assertj.core.util.Lists;

import java.util.List;
import com.alibaba.fastjson.JSONObject;
/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-03-29 09:15
 */
public class TestRetain {
    public static void main(String[] args) {


        List<String> list1 = Lists.newArrayList("1_2","2_5","5_1");
        List<Integer> list2 = Lists.newArrayList(2,3,4,5);
        List<String> list3 = Lists.newArrayList("1_2","2_5","2_4");
//        list2.retainAll(list1);
//
//        System.out.println(JSONObject.toJSONString(list2));

        list3.removeAll(list1);

        System.out.println(JSONObject.toJSONString(list3));
    }
}
