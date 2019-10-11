/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-07-07 00:19
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {

        System.out.println(ClassLoaderDemo.class.getClassLoader());
        System.out.println(String.class);
        System.out.println(String.class.getClassLoader());
        System.out.println(Integer.class.getClassLoader());

    }

}
