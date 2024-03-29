package easy;

/**
 * @ClassName NO181
 * @Description 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 *
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方；6 和 9 同理，
 * 除了这些以外其他的数字旋转以后都不再是有效的数字。
 *
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 *
 * N 的取值范围是 [1, 10000]。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotated-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/30 16:24
 */
public class NO181 {
    public static void main(String[] args) {
        NO181 no181 = new NO181();
        System.out.println(no181.rotatedDigits(2));
    }
    public int rotatedDigits(int N) {
        int sum = 0;
        int[] ints = new int[]{0,0,1,-1,-1,1,1,-1,0,1};
        for (int i = 2; i <= N; i++) {
            if (check(i,ints)){
                sum ++;
            }
        }
        return sum;
    }

    public boolean check(int n,int[] ints){
        boolean falg = false;
        while (n != 0){
            int k = n % 10;
            if (ints[k] != 0){
                if (ints[k] == 1){
                    falg = true;
                }else {
                    return false;
                }
            }
            n /= 10;
        }
        return falg;
    }
}
