import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 不依赖于特定的接口，可以用两个接口的方式，如rmi
 *
 * @author zhengyumin
 * @create 2019-03-28 09:20
 */
public class DefaultCommonMethod implements CommonMethodTest1,CommonMethodTest2 {

    @Override
    public void doSomething() {
        System.out.println("say hello");
    }

    public static void main(String[] args) {

        Long time = 1553702400000L;
        System.out.println(new SimpleDateFormat("yyyyMMdd").format(new Date(time)));

    }
}


