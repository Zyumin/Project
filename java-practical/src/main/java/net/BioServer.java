package net;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {
    public static void main(String[] args) throws IOException {
        //这里可以直接写成ServerSocket server = new ServerSocket(10101);
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(10101));
        System.out.println("服务器启动");
        while (true) {
            //此处会阻塞
            Socket socket = server.accept();
            System.out.println("来了一个新客户端");
            handler(socket);
        }
    }
    public static void handler(Socket socket) {
        try {
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            while (true) {
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println(new String(bytes,0,read));
                }else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                System.out.println("socket关闭");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}