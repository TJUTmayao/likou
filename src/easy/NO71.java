package easy;

/**
 * @ClassName NO71
 * @Description 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * @Author 11432
 * @DATE 2019/7/20 14:35
 */
public class NO71 {

    /** 循环迭代 */
    public boolean isPowerOfThree(int n) {
        if (n < 1){
            return false;
        }
        while (n % 3 == 0 && n > 1){
            n /= 3;
        }
        return n == 1;
    }

    /** 基准替换 */
    public boolean isPowerOfThree2(int n) {
        String string = Integer.toString(n, 3);
        return string.matches("10*$");
    }

    /** int 类型限制，找出int中最大的3的幂 1162261467 */
    public boolean isPowerOfThree3(int n) {
        if (n < 1){
            return false;
        }
        return 1162261467 % n == 0 && 1162261467 >= n;
    }


    /** ------------------------------------------------------------ 4的幂 --------------------------------------------------------------------*/

    public boolean isPowerOfThree4(int num) {
        if (num < 1){
            return false;
        }
        while (num % 4 == 0 && num > 1){
            num = num >> 2;
        }
        return num == 1;
    }

    public boolean isPowerOfThree5(int num) {
        if (num >= 1073741824 || num < 1){
            return num == 1073741824;
        }
        int s = 1;
        while (s < num){
            s = s << 2;
        }
        return num == s;
    }


    /** 位运算 ，32位 奇数位只有一个1，偶数位都是偶数 */
    public boolean isPowerOfThree6(int num) {
        if (num < 1){
            return false;
        }
        return (num & 0xaaaaaaaa) == 0 && Integer.bitCount(num)==1;
    }

}
