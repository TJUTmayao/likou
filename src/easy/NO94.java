package easy;

/**
 * @ClassName NO94
 * @Description 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 *              给定一个数字 n，找出可形成完整阶梯行的总行数。
 *              n 是一个非负整数，并且在32位有符号整型的范围内。
 * @Author 11432
 * @DATE 2019/7/29 14:27
 */
public class NO94 {
    public static void main(String[] args) {
        System.out.println(arrangeCoins2(5));
//        System.out.println(Math.sqrt(Integer.MAX_VALUE));
    }

    /** 暴力法 超时 */
    public int arrangeCoins(int n) {
        int num = 0;
        for (int i = 0; i <= n; i++) {
            num += i;
            if (num >= n){
                return num > n ? i - 1 : i;
            }
        }
        return 0;
    }

    public static int arrangeCoins2(int n) {
        int start = 0,end = n > 92681 ? 92681 : n;
        int mid = 0;
        while (start <= end){
            mid = start + ((end - start) >> 1);
            long k =(long) mid * (mid + 1) / 2 ;
            if (k >= n){
                if (k == n){
                    return mid;
                }else if (k - mid < n){
                    return mid - 1;
                }
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return mid;
    }
}
