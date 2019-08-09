package easy;

/**
 * @ClassName NO113
 * @Description 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 *
 * 给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False
 * 输入: 28
 * 输出: True
 * 解释: 28 = 1 + 2 + 4 + 7 + 14
 *
 * @Author 11432
 * @DATE 2019/8/7 16:11
 */
public class NO113 {
    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
    }
    public static boolean checkPerfectNumber(int num) {
        if (num == 1){
            return false;
        }
        int i = 1,j;
        int x = 1;
        double sqrt = Math.sqrt(num);
        while (i < sqrt){
            i++;
            if (num % i == 0){
                j = num / i;
                if (i > j){
                    break;
                }
                x += i + j;
            }
        }
        return num == x;
    }
}
