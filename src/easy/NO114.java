package easy;

/**
 * @ClassName NO114
 * @Description 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。给定 N，计算 F(N)。
 * @Author 11432
 * @DATE 2019/8/7 16:31
 */
public class NO114 {

    /** 非递归 */
    public int fib(int N) {
        int a = 0;
        int b = 1;
        if (N == 0){
            return a;
        }
        N -= 2;
        while (N > 0){
            b = a + b;
            a = b - a;
            N--;
        }
        return b;
    }

    /** 递归 */
    public int fib2(int N) {
        if (N <= 0){
            return 0;
        }
        if (N == 1){
            return 1;
        }
        return fib(N - 1) + fib(N - 2);
    }
}
