package easy;

/**
 * @ClassName NO42
 * @Description 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * @Author 11432
 * @DATE 2019/7/13 16:34
 */
public class NO42 {

    public static void main(String[] args) {
        System.out.println();
    }
    /** 第一次 /5 获取有多少个5 ，第二次 /5 获取有多少25 ，第三次 /5 获取有多少125 ... 以此类推 */
    /** 0的个数 = 5的个数 + 25的个数 + 125的个数...  */
    public int trailingZeroes(int n) {
        int num = 0;
        while (n > 0){
            n = n / 5;
            num += n;
        }
        return num;
    }

}
