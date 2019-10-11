package nio;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2019-09-26 9:29 AM
 */
public class NioServerBootstrap {

    public static void main(String[] args) {
        try(NioServer nioServer =  NioServer.port(9999)) {
            nioServer.start();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
