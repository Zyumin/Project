package nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2019-09-24 11:44 PM
 */
public class ChannelDemo {
    public static void main(String[] args) throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("/Users/zhengyumin/java_error_in_idea_1461.log", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.err.println("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();

    }
}
