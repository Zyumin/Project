package net;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2019-09-30 5:08 PM
 */
public class HttpServer {
    public static void main(String[] args) throws IOException {

        com.sun.net.httpserver.HttpServer server = com.sun.net.httpserver.HttpServer.create();
        server.bind(new InetSocketAddress(10101),0);
        server.start();
//        while (true){
//            server.
//        }
    }
}
