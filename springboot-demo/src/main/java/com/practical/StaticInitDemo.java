package com.practical;

class MyClass {
    static {//静态块  
        System.err.println("static block run");
    }
    static String init(){
        return "init";
    }
}

/**
 * 静态代码块的执行是处在类加载的最后一个阶段“初始化”
 *
 * 加载 、验证、准备、解析、初始化
 */
public class StaticInitDemo {
    public static void main(String[] args) {

        //只是加载
        System.out.println("run MyClass.class");
        Class c = MyClass.class;


        System.out.println("run ClassLoader.loadClass");
        try {
            Thread.currentThread().getContextClassLoader().loadClass("com.practical.MyClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("run Class forName");
        try {
            Class.forName("com.practical.MyClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

//结论： 实际使用初始化才会 或者class.forname
//        System.out.println("hello word: " + MyClass1.init());
