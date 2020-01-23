package proxy;


/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2019-11-20 10:22 AM
 */
public class JDKProxy {

    public static void main(String[] args) {

        SayHello sayHello = (SayHello) new DemoHandler().newProxyInstance(new SayHelloImpl());

        sayHello.hello();
    }

}




