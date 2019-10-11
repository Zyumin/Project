package lambda;

import java.util.Arrays;
import java.util.List;

/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-07-01 15:42
 */
public class Demo {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("123", "45634", "7892", "abch", "sdfhrthj", "mvkd");
        list.stream().forEach(e ->{
            if(e.length() >= 5){
                throw new RuntimeException("break");
            }
            System.out.println(e);
        });
    }
}
