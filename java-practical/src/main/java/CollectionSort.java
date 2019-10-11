import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * Collections sort 要满足自反性否则会有概率出错，在1.7中会有问题
 * @author zhengyumin
 * @create 2019-07-18 10:24
 */
public class CollectionSort {


    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(
                0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 2, 1, 0, 0, 0, 2, 30, 0, 3);

//        Collections.reverse(list);
        list.sort((o1, o2) -> o1 > o2 ? 1 : -1);

        list.stream().forEach((Consumer) o -> System.out.println(o));
    }
}
