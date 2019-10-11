package collection;

/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-08-01 17:54
 */
public class Generis {
    public static void main(String[] args) {

//        Class<Integer> ki = Integer.class;
//        Number n = new Integer(42);
//        Class<? extends Number> kn = n.getClass();
//        assert ki == kn;

        Class ki = Integer.class; Number n = new Integer(42); Class kn = n.getClass(); assert ki == kn;
    }
}
