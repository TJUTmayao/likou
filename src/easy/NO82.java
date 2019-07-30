package easy;

/**
 * @ClassName NO82
 * @Description 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 * @Author 11432
 * @DATE 2019/7/22 14:59
 */
public class NO82 {

    public static void main(String[] args) {
        //                           123456790
        System.out.println(getWei(1000000));
        //                                 1000000004
        System.out.println(findNthDigit(28));
    }

    /** 参考之后改进 */
    public static int findNthDigit(int n) {
        long num = 0;
        long x = 10;
        int wei = 1;
        long y = 9;
        while (num < n){
            num += y * wei;
            y *= 10;
            x *= 10;
            wei ++;
        }
        x = x/10;
        long k = num - n;
        wei --;
        if (k % wei == 0){
            return (int) ((x - k / wei - 1) % 10);
        }else {
            String string = (x - k / wei - 1) + "";
            return string.charAt((int)(string.length() - 1 - (k % wei))) - '0';
        }
    }


    /** 二分 + 函数   n位数 = 9*1 + 90*2 + 900*3 + 9000*4 。。。。*/
    public static int findNthDigit2(int n) {
        int start = 1,end = n;
        int mid;
        while (start <= end){
            mid = start + ((end - start) >> 1);
            long wei = getWei(mid);
            if (wei < n){
                start = mid + 1;
            }else if (wei >= n){
                long last = getWei(mid - 1);
                if (last < n){
                    String string = mid + "";
                    long i;
                    for (i = last + 1;i < n; i++) { }
                    return string.charAt((int)(i - last - 1)) - '0';
                }
                end = mid - 1;
            }
        }
        return 0;
    }

    public static long getWei(int n){
        long x = 10;
        long y = 9;
        long wei = 1;
        long num = 0;
        while (x <= n){
            num += wei * y;
            y *= 10;
            wei ++;
            x *= 10;
        }
        x /= 10;
        num += wei * (n - x + 1);
        return num;
    }
}
