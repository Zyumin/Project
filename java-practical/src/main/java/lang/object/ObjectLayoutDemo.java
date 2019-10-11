package lang.object;

import org.openjdk.jol.info.ClassLayout;

/**
 * todo 写点注释
 *
 * @author zhengyuminuse
 * @create 2019-08-17 15:42
 */
public class ObjectLayoutDemo {
    public static class A {
        boolean flag = false;
        int i = 0 ;

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.err.println("object final ");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        System.out.println(ClassLayout.parseInstance(a).toPrintable());

        // 手动调用hashCode 触发懒加载

        System.out.println(Integer.toBinaryString(a.hashCode()));
        System.out.println(ClassLayout.parseInstance(a).toPrintable());

    }
}
