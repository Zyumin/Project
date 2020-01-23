package bbp.none;

import org.springframework.beans.factory.SmartInitializingSingleton;

/**
 * @author zhengyumin
 * @description 所有单例初始化后的回调
 * @date 2020-01-16 10:13 AM
 */
public class SmartInitializingSingletonDemo  implements SmartInitializingSingleton {

    @Override
    public void afterSingletonsInstantiated() {
        System.err.println("SmartInitializingSingleton#afterSingletonsInstantiated");
    }
}
