import java.math.BigDecimal;

/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-03-28 09:19
 */
public interface CommonMethodTest1 {
    void doSomething();

    public static void main(String[] args) {




        String val = "19.9";
        long lval  = new BigDecimal(val).multiply(new BigDecimal("100")).longValue();
        System.out.println(lval);
    }
}
