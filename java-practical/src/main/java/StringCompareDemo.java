/**
 * ==比较地址 equals 比较char 字节
 *
 * @author zhengyumin
 * @create 2019-07-17 16:41
 */
public class StringCompareDemo {

    public static void main(String[] args) {

        String a = new String(1 + "class");
        String b = new String("1class");
        System.out.println(a == b);


        String a1 = 1 + "class";
        String b1 = "1class";
        System.out.println(a1 == b1);

        System.out.println(a1.equals(b1));
    }
}
