package net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

/**
 * @author zhengyumin
 * @description tomcat监听8080
 * @date 2019-10-12 2:24 PM
 */
public class PortDemo {
    public static void main(String[] args) throws UnknownHostException {

        try {
//            new ServerSocket(8080, 1, InetAddress.getByName("127.0.0.1"));
            new ServerSocket(8080, 1, InetAddress.getByName("0.0.0.0"));
//            new ServerSocket(8080, 1, InetAddress.getByName("localhost"));
//            new ServerSocket(8080, 1, InetAddress.getByName("localhost"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String hostname = InetAddress.getLocalHost().getHostName();
        System.out.println(hostname);
        InetAddress[] addresses = InetAddress.getAllByName(hostname);
        for (InetAddress a : addresses) {
            System.out.println(a);
        }
//
//        try {
//            new ServerSocket(8080);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
