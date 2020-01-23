package circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2019-11-30 4:36 PM
 */
@Service
public class DemoB {

    @Autowired
    private DemoA a;

    public DemoB() {
        System.out.println("init DemoB");
    }

    public void say(){
        System.out.println("hi");
    }
}
