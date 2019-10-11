package collection;

import java.util.Collections;
import java.util.List;

/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-07-29 10:25
 */
public class FrequencyDemo {
    public static void main(String[] args) {

        List s = Collections.nCopies(3,1);
        //统计
//        System.out.println(Collections.frequency(s,0));
//        s.add(2);
        List s1 = Collections.nCopies(2,1);
        //是否相交
        System.out.println(Collections.disjoint(s,s1));

        s.stream().forEach(o -> System.out.println(o));


    }
}
