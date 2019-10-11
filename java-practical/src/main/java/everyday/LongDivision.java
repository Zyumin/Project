package everyday;

public class LongDivision {
    
    private static final long MILLIS_PER_DAY
            = 24 * 60 * 60 * 1000;
    
    private static final long MICROS_PER_DAY
            = 24 * 60 * 60 * 1000 * 1000;

    private static final long MICROS_PER_DAY_L
            = 24L * 60 * 60 * 1000 * 1000;

    public static void main(String[] args) {
        System.out.println(MILLIS_PER_DAY);
        //超出int类型 。只取低32位
        System.out.println(MICROS_PER_DAY);
        System.out.println(Integer.MAX_VALUE);
        //模拟只取低32位
        System.out.println(MICROS_PER_DAY_L&Integer.MAX_VALUE );


        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);
    }
}

