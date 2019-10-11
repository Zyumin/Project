package lang.Throwble;

/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-09-02 09:50
 */
public class ThrowableDemo {
    public static void main(String[] args) {
        try {
            lowStack();
        }catch (Exception e){
            e.printStackTrace();
//            System.out.println(e.getCause());
//            throw new RuntimeException();

        }

    }


    public static void lowStack(){
        try {

            System.out.println(10/0);
        }catch (Throwable e){
            System.out.println(e);
            System.out.println( e.getCause());
            System.out.println( e.getStackTrace());
            System.out.println( e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
