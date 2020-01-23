package net;

import java.net.URI;

/**
 *
 * URI：Uniform Resource Identifier，统一资源标识符
   URL：Uniform Resource Location统一资源定位符
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2019-09-30 5:18 PM
 */
public class URIDemo {
    public static void main(String[] args) throws Exception {

        URI uri = new URI("http://127.0.0.1:8080/test/tets?a=123");
        System.out.println(uri.getPath());
        System.out.println(uri.getHost());
        System.out.println(uri.getPort());
        System.out.println(uri.getQuery());


    }
}
