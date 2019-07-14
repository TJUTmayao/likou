package easy;

/**
 * @ClassName NO45
 * @Description 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）
 * @Author 11432
 * @DATE 2019/7/14 12:55
 */
public class NO45 {

    public static void main(String[] args) {
        System.out.println(hammingWeight(-3));
    }
    /** 位运算 1 */
    public static int hammingWeight(int n) {
        int num = 0;
        while (n != 0){
//            if ((n & 1) == 1){
//                num ++;
//            }
            num += n & 1; // 为上方代码的优化
            n = n >>> 1;
        }
        return num;
    }

    /** 位运算 2*/
    public static int hammingWeight2(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            //保证把最低位的 1 变为 0，因为若末位不为 1 ，就要向前一位借 1，依次类推，总能把当前的最低位的1 变为 0
            n &= (n - 1);
        }
        return sum;
    }
}
