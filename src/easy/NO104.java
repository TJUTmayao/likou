package easy;

/**
 * @ClassName NO104
 * @Description 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 *
 * 注意:
 *
 * 给定的整数保证在32位带符号整数的范围内。
 * 你可以假定二进制数不包含前导零位。
 * @Author 11432
 * @DATE 2019/8/4 18:03
 */
public class NO104 {
    public static void main(String[] args) {
        System.out.println(findComplement(4));
//        System.out.println(((0 >> 1) | 1) << 1);
    }

    public static int findComplement(int num) {
        int i = 0;
        int res = 0;
        while (num > 0){
            if((num & 1) == 0){
                res = (res | 1 << i);
            }
            num >>= 1;
            i++;
        }
        return res;
    }
}
