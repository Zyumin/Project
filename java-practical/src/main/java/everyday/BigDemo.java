package everyday;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-07-18 16:36
 */
public class BigDemo {

    public static void main(String[] args) {
//        System.out.println(BigDecimal.valueOf(555555555555555.235).setScale(2, RoundingMode.HALF_UP).doubleValue());
//        System.out.println(BigDecimal.valueOf(55555555555555.235).setScale(2, RoundingMode.HALF_UP).doubleValue());
//        System.out.println(BigDecimal.valueOf(5555555555555.235).setScale(2, RoundingMode.HALF_UP).doubleValue());
//

       System.out.println(BigDecimal.valueOf(0.0001*100).setScale(2, RoundingMode.HALF_UP).doubleValue());



//        System.out.println(555555555555555.235);


        Double d = new Double(555555555555555.235);
        System.out.println(d.doubleValue());
        System.out.println(d.toString());

        BigDecimal divisorBigDecimal = new BigDecimal(String.valueOf(d));
        System.out.println(divisorBigDecimal.doubleValue());
        System.out.println(divisorBigDecimal.toPlainString());
        System.out.println(divisorBigDecimal.toEngineeringString());
        System.out.println(divisorBigDecimal.toString());



//        BigDecimal d = BigDecimal.valueOf(555555555555555.235).setScale(2, RoundingMode.HALF_UP);
//
//        BigDecimal d1 = BigDecimal.valueOf(Double.MAX_VALUE);
//
//        System.out.println(d1.toString());
//
//        System.out.println( d.equals(d1));
//        System.out.println(BigDecimal.valueOf(555555555555555.235).setScale(2, RoundingMode.HALF_UP).toPlainString());
//
//        double doublenum =  BigDecimal.valueOf(555555555555555.235).setScale(2, RoundingMode.HALF_UP).doubleValue();
//        System.out.println(doublenum);

//
//
//        System.out.println(BigDecimal.valueOf(55555555555555.235).setScale(2, RoundingMode.HALF_UP).doubleValue());
//        System.out.println(BigDecimal.valueOf(5555555555555.235).setScale(2, RoundingMode.HALF_UP).doubleValue());
        /**
         * 555555555555555.25
         * 55555555555555.23
         * 5555555555555.24
         */
//        BigDecimal divisorBigDecimalb = new BigDecimal(String.valueOf(1));
//
//
//        BigDecimal divisorBigDecimal = new BigDecimal(String.valueOf(555555555555555.235));
//        System.out.println(divisorBigDecimal.divide(divisorBigDecimalb,2,RoundingMode.HALF_UP).doubleValue());
//
//        BigDecimal divisorBigDecimal1 = new BigDecimal(String.valueOf(55555555555555.235));
//        System.out.println(divisorBigDecimal1.divide(divisorBigDecimalb,2,RoundingMode.HALF_UP).doubleValue());
//
//        BigDecimal divisorBigDecimal2 = new BigDecimal(String.valueOf(5555555555555.235));
//        System.out.println(divisorBigDecimal2.divide(divisorBigDecimalb,2,RoundingMode.HALF_UP).doubleValue());
    }
}
