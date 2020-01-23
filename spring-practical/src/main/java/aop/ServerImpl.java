package aop;

import org.springframework.stereotype.Component;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-01-22 9:53 PM
 */
@Component
public class ServerImpl implements Server {

    @Override
    public void doSomething() {
        System.out.println("do something.....");
    }
}
