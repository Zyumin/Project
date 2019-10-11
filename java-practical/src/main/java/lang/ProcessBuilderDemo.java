package lang;

import java.io.IOException;

/**
 * 进程启动cmd命令类似
 *
 * @author zhengyumin
 * @create 2019-08-07 19:38
 */
public class ProcessBuilderDemo {
    public static void main(String[] args) {


        try {
            Process start = new ProcessBuilder("jconsole").start();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        start.
    }
}
