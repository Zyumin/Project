package net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2019-09-30 4:44 PM
 */
public class Server {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(10101));

        String newData = "New String to write to file..." + System.currentTimeMillis();
//
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());

        buf.flip();
        while(buf.hasRemaining()){
            socket.getOutputStream().write(buf.get());

        }

//        socket.getOutputStream().write(newData.getBytes());

    }
}
