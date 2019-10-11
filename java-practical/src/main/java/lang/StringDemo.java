package lang;

/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-08-08 20:41
 */
public class StringDemo {

    public static void main(String[] args) {

        trim();

    }

    public static void equalsString(){
        char a = 'a';
        String s = String.valueOf(a);
        String s2 = String.valueOf(a);

        String s3 = String.valueOf(1);
        String s4 = String.valueOf(1);

        System.out.println(s==s2);
        System.out.println(s3==s4);

        //print false  String.valueOf == new String
    }

    public static void trim(){
        String a = " a a ";
        System.out.println(a.trim());
    }

    public static void test(){

        Character aa = ' ';
        System.out.println((byte)' ');

        String s = "intern";
        String s1 = "intern";

        String a = new String("intern");
        String b = new String("intern");
        System.out.println(s==s1);

        s = a;
        System.out.println(s==a);

        System.out.println(s1==b.intern());
    }

     public static void byteTest(){


         String s = "123";
         for(byte b:s.getBytes()){
             System.out.println(b);
         }

    }
}
