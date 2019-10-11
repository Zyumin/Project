package com.practical;

import java.lang.reflect.Field;
import java.util.Vector;


/**
 * Class.forName() 这样调用在加载过程会执行静态代码块。
 * 但是：不代表所有的forName()方法的调用都会执行“静态代码块”。
 * 并且他的Class对象存储在ClassLoader中
 */
public class Main {
 
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        printClassesOfClassLoader(loader);
//        System.out.println(MyClass.class.getName(),false,loader);
//        Class.forName("com.practical.MyClass",false,loader);
//        loader.loadClass("com.practical.MyClass");//
//        MyClass c = new MyClass();

//        System.out.println("-------------------- hello " + MyClass.class + " --------------------");
        printClassesOfClassLoader(loader);
 
    }
    
    public static void printClassesOfClassLoader(ClassLoader loader){
        try {
            Field classesF = ClassLoader.class.getDeclaredField("classes");
            classesF.setAccessible(true);
            Vector<Class<?>> classes = (Vector<Class<?>>) classesF.get(loader);
            for(Class c : classes) {
                System.out.println(c);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    }

