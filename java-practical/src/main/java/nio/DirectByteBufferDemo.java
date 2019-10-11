package nio;

import java.nio.ByteBuffer;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2019-09-30 9:15 AM
 */
public class DirectByteBufferDemo {
    private static final int M_1 = 1024*1024;

    private static Byte b = new Byte((byte)1);

    public static void main(String[] args) {
        ByteBuffer directByteBuffer = ByteBuffer.allocateDirect(M_1*1280);
        synchronized (b){
            try {
                b.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
