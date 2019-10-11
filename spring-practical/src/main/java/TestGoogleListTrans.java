import com.google.common.base.Function;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-03-29 09:14
 */
public class TestGoogleListTrans {
    public static void main(String[] args) {
//        List<Demo> listDemo = Lists.newArrayList(new Demo(1),new Demo(2));
//
//        List<Integer> list = Lists.transform(listDemo, new Function<Demo, Integer>() {
//
//
//            @Override
//            public Integer apply(Demo demo) {
//                if(demo.getA()==1){
//                    return null;
//                }else{
//                    return demo.getA();
//                }
//
//            }
//        });
//        for(Integer a :list){
//            System.out.println("value:"+a);
//        }

        final Demo demo = new Demo(2);
        demo.setA(3);
        System.out.println(demo.getA());
    }

    static class Demo{
        private int a;

        public Demo(int a) {
            this.a = a;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }
    }
}
