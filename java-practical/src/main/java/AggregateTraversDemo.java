import com.sun.tools.javac.util.List;

/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-07-23 20:00
 */
public class AggregateTraversDemo {
    public static void main(String[] args) {

        List myShapesCollection = List.of(1,2,3,4);
        myShapesCollection.parallelStream()
                .forEach(e -> System.out.println(e));
    }
}
