package easy;

/**
 * @ClassName NO18
 * @Description 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 * @Author 11432
 * @DATE 2019/7/5 13:36
 */
public class NO18 {
    public static void main(String[] args) {
        System.out.println(climbStairs(44));
    }


    public static int climbStairs(int n) {
//        return climbStairs1(n, 0);
//        return climbStairs2(0,n,new int[n]);
//        return climbStairs3(n);
        return climbStairs5(n);
    }

    /** 暴力法 */
    public static int climbStairs1(int n,int num){
        if (n == 0){
            return 1;
        }
        if (n < 0){
            return 0;
        }
        return climbStairs1(n - 1,num) + climbStairs1(n - 2,num);
    }

    /** 数组辅助 */
    public static int climbStairs2(int i,int n,int[] nums){
        if (i == n){
            return 1;
        }
        if (i > n){
            return 0;
        }
        if (nums[i] > 0){
            return nums[i];
        }
        nums[i] = climbStairs2(i + 1,n,nums) + climbStairs2(i + 2,n,nums);
        return nums[i];
    }

    /** 动态规划 */
    public static int climbStairs3(int n){
        int[] nums = new int[n + 1];
        nums[1] = 1;
        nums[2] = 2;
        for (int i = 3; i <= n; i ++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }

    /** 斐波那契数列 */
    public static int climbStairs4(int n){
       int a,b;
       a = 1;
       b = 2;
       int result = 0;
       if (n == 1){return 1;}
       if (n == 2){return 2;}
        for (int i = 2; i < n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

    private static final double sqrt5 = Math.sqrt(5);
    /** 公式 方法  根号5分之一 * （二分之一加根号5的n+1次方 - 二分之一减根号5的n+1次方）*/
    public static int climbStairs5(int n){
       double re = Math.pow((1 + sqrt5) / 2,n + 1) - Math.pow((1 - sqrt5) / 2,n + 1);
       return (int) (re / sqrt5);
    }
}
