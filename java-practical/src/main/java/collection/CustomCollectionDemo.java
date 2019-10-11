package collection;

import java.util.AbstractList;
import java.util.Arrays;

/**
 * todo 写点注释
 *
 * @see //https://docs.oracle.com/javase/tutorial/collections/custom-implementations/index.html
 * @author zhengyumin
 * @create 2019-07-29 10:46
 */
public class CustomCollectionDemo<T> extends AbstractList<T> {
    public static void main(String[] args) {
        Integer [] a = new Integer[5];
        CustomCollectionDemo customCollectionDemo = new CustomCollectionDemo(a);


//        customCollectionDemo.add(1);
        customCollectionDemo.set(1,2);

        customCollectionDemo.stream().forEach(o-> System.out.println(o));

        Arrays.asList();
//        Collections.list(e)
    }

    private final T[] a;

    CustomCollectionDemo(T[] array) {
        a = array;
    }

    @Override
    public T get(int index) {
        return a[index];
    }

    @Override
    public T set(int index, T element) {
        T oldValue = a[index];
        a[index] = element;
        return oldValue;
    }

//    @Override
//    public boolean add(T o) {
//        return super.add(o);
//    }

    @Override
    public int size() {
        return a.length;
    }
}
