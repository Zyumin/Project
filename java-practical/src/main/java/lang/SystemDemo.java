package lang;

import com.alibaba.fastjson.JSON;

import static com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat;

/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-08-08 16:40
 */
public class SystemDemo {
    public static void main(String[] args) {


        System.out.println(JSON.toJSONString(System.getenv(),PrettyFormat));
        System.out.println(JSON.toJSONString( System.getProperties(),PrettyFormat));



    }
}
