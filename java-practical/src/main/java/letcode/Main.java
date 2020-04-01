package letcode;

import java.util.Stack;

/**
 * 实现push pop max O(1)复杂度
 */
public class Main {

    static Stack<Integer> stack1 = new Stack();
    static Stack<Integer> stack2 = new Stack();
    
    public static void main(String[] args) {
 
         int []input = new int[]{1,9,2,16,4,18,7};
         solution(input);
        System.out.println("Hello World!");
    }
    
    public static void solution(int []input){
       for(int i:input){
           System.out.println("push value:"+i);
           push(i);
           System.out.println("max value:"+max());
       }
        System.out.println("-------------------------");
       while(!stack1.isEmpty()){
           System.out.println("pop value:"+pop());
           System.out.println("max value:"+max());
       }
    }
    
    public static void push(int val){
        stack1.push(val);
        if(stack2.isEmpty()){
            stack2.push(val);
            return;
        }

       int temp = stack2.peek();

        stack2.push(val>temp?val:temp);

        
    }
    public static int pop(){

        stack2.pop();
        return stack1.pop();    
    }
    public static int max(){
        if(stack2.isEmpty()){
            return 0;
        }
        return stack2.peek();
    }
    
}