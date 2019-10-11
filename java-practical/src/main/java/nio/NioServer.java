package nio;

import org.springframework.util.StringUtils;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author zhengyumin
 * @description Nio服务端 使用selector接收消息
 * @date 2019-09-25 1:22 AM
 */
public class NioServer implements Closeable{

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    private int port;

    private String hostname;

    public NioServer(int port) {
        this.port = port;
    }

    public NioServer(int port, String hostname) {
        this.port = port;
        this.hostname = hostname;
    }

    public static NioServer port(int port) {
        return new NioServer(port);
    }

    public NioServer start() {

        System.out.println("starting....");

        try {
            startServer();
            //开启selector 并监听
            startSelector();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public void close() {
        try {
            System.out.println("closing....");
            selector.close();
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startSelector() throws IOException {
        selector = Selector.open();

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("startSelector succ");

        while (true) {

            int readyChannels = selector.selectNow();

            if (readyChannels == 0) {
                continue;
//                    return;
            }

            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()) {
                    // a connection was accepted by a ServerSocketChannel.
                    connectEven(key, selector);
                } else if (key.isConnectable()) {
                    // a connection was established with a remote server.
                    System.out.println("a connection was established with a remote server.");
                } else if (key.isReadable()) {
                    // a channel is ready for reading
                    readData(key);
                } else if (key.isWritable()) {
                    // a channel is ready for writing
                    System.out.println("a channel is ready for writing");
                }
                keyIterator.remove();
            }
        }
    }

    private void startServer() throws Exception {
        //开启服务器
        serverSocketChannel = ServerSocketChannel.open();


        serverSocketChannel.socket().bind(StringUtils.isEmpty(hostname) ?
                new InetSocketAddress(port) : new InetSocketAddress(hostname, port));

        serverSocketChannel.configureBlocking(false);

        System.out.println("startServer succ");

    }


    private void connectEven(SelectionKey key, Selector selector) {
        try {
            ServerSocketChannel server = (ServerSocketChannel) key.channel();
            SocketChannel channel = server.accept();
            channel.configureBlocking(false);
            //获得远程连接的IP地址
            System.out.println("已有连接，连接的ip地址是" + channel.socket().getInetAddress());
            channel.register(selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 数据读取处理
     *
     * @param key
     */
    private void readData(SelectionKey key) {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        try {
            int readSize = socketChannel.read(buf);
            if (readSize > 0) {
                byte[] data = buf.array();
                String msg = new String(data, "UTF-8").trim();
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try(NioServer nioServer =  NioServer.port(9999)) {
            nioServer.start();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
