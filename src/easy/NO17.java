package easy;

/**
 * @ClassName NO17
 * @Description 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * @Author 11432
 * @DATE 2019/6/23 11:13
 */
public class NO17 {

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
    /** 二分法 挨个试 */
    public static int mySqrt(int x) {
        int start = 0, end = x;
        int middle = 0;
        long re = 0;
        if (end > 46340){
            end = 46340;
        }
        for (; start <= end && re != x;) {
            middle = start + (end - start) / 2;
            re = middle * middle;
            if (re > x){
                end = middle - 1;
            }
            if (re < x){
                start = middle + 1;
            }
        }
        return re > x ? middle - 1 : middle;
    }

    /** 牛顿迭代法 n = X*X ==> x*x - n = f(x)
     *  迭代方程： 下一个迭代值 = 上一个迭代值 - f(上一个迭代值) / f'(上一个迭代值)
     * */
    public static int mySqrt2(int x) {
        if ( x == 0){
            return x;
        }
        double lastResult = 0.0;
        double thisResult = x;
        for (;(int)lastResult != (int)thisResult;){
            lastResult = thisResult;
            thisResult = (lastResult + x / lastResult) / 2;
        }
        return (int) thisResult;
    }
}
