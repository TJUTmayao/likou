package easy;

/**
 * @ClassName NO176
 * @Description 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
 *
 * (注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。)
 *
 * 来源：力扣(LeetCode)
 * 链接：https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/28 16:15
 */
public class NO176 {
    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(10,15));
    }
    /** 找 */
    public static int countPrimeSetBits(int L, int R) {
        int[] ints = new int[]{0,0,1,1,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0,1,0,1,0};
        int num = 0;
        for (int i = L; i <= R ; i++) {
            int k = i;
            int j = 0;
            while (k != 0){
                if ((k & 1) == 1){
                    j++;
                }
                k >>= 1;
            }
            if (ints[j] == 1){
                num ++;
            }
        }
        return num;
    }
}
