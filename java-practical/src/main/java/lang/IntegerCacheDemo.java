package lang;

/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-08-08 10:56
 */
public class IntegerCacheDemo {

    public static void main(String[] args) {


        System.out.println(sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high"));


        System.getProperties();
        Integer i = new Integer(1);
        Integer i2 = new Integer(1);

        Integer i3 = Integer.valueOf(127);
        Integer i4 = 127;

        Integer i5 = Integer.valueOf(199);
        Integer i6 = 199;



        System.out.println(i==i2);
        System.out.println(i3==i4);
        System.out.println(i5==i6);

    }


}
