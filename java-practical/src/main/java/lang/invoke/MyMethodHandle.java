package lang.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;

public class MyMethodHandle {

	@Override
	public String toString() {
		return super.toString() + "==MethodHandle";
	}

	public static void main(String[] args) throws Throwable{
		MyMethodHandle handle = new MyMethodHandle();

		//1.获取methodType 需指定返回值
		MethodType methodType = MethodType.methodType(String.class);

		//2.获取MethodHandle, MethodHandle.Lookup相当于MethodHandle工厂类 还可以通过反射获取
		Lookup lookup = MethodHandles.lookup();
		MethodHandle methodHandle = lookup.findVirtual(MyMethodHandle.class, "toString", methodType);

		//3.调用 1
		String toString = (String) methodHandle.invokeExact(handle);
		System.out.println(toString);
		//3.调用 2
		MethodHandle methodHandle2 = methodHandle.bindTo(handle);
		String toString2 = (String) methodHandle2.invokeWithArguments();
		System.out.println(toString2);
		
		// 得到当前Class的不同表示方法，最后一个最好。一般我们在静态上下文用SLF4J得到logger用。  
        System.out.println(MyMethodHandle.class);
        System.out.println(handle.getClass());  
        System.out.println(MethodHandles.lookup().lookupClass()); // like getClass()  
	}
	
}