package letcode;


public class Solution {

    /**
     * 爬楼梯
     */
    public int climbStairs(int n) {
        return climb_Stairs(0, n);
    }

    public int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }

    /**
     * 反转
     * @param x
     * @return
     */
    public int reverse(int x) {
        try {
            if(x>0){
                String str = String.valueOf(x);

                return Integer.parseInt(new StringBuffer(str).reverse().toString());
            }else{
                x = Math.abs(x);
                String str = String.valueOf(x);

                return -Integer.parseInt(new StringBuffer(str).reverse().toString());
            }
        }catch (NumberFormatException e){
            return 0;
        }


    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(1534236469));
    }

}

