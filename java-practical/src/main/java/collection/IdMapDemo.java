package collection;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-08-07 19:09
 */
public class IdMapDemo {


    // 用的==比较
    public static void main(String[] args) {
        Map identityMap = new IdentityHashMap();
        identityMap.put("a", 1);
        identityMap.put(new String("a"), 2);
        identityMap.put("a", 3);
        //输出结果为Identity Map KeySet Size :: 2
        System.out.println("Identity Map KeySet Size :: " +  identityMap.keySet().size());

        identityMap.values().stream().forEach(o->System.out.println(o));

    }
}
