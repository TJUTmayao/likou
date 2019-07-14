package easy;

/**
 * @ClassName NO49
 * @Description 统计所有小于非负整数 n 的质数的数量。
 * @Author 11432
 * @DATE 2019/7/14 14:37
 */
public class NO49 {
    public static void main(String[] args) {
        System.out.println(countPrimes1(3));
    }
    
    /** 暴力法 */
    public static int countPrimes(int n) {
        int count = 0;
        boolean flag;
        for (int i = 2; i < n; i++) {
            flag = false;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0){
                    flag = true;
                }
            }
            if (!flag){
                count ++;
            }
        }
        return count;
    }

    /** 埃拉托斯特尼筛法 要得到自然数n以内的全部素数，必须把不大于 根号n 的所有素数的倍数剔除，剩下的就是素数。*/
    public static int countPrimes1(int n) {
        // 防止重复统计
        boolean[] bools = new boolean[n];
        int count = 0;
        // 求小于 根号n 的所有素数
        for (int i = 2; i * i < n; i++) {
            // 防止重复计算
            if (!bools[i]){
                // 将素数变为true
                for (int j = i * i; j  < n; j += i) {
                    bools[j] = true;
                }
            }
        }
        // 统计质数
        for (int i = 2; i < bools.length; i++) {
            if (!bools[i]){
                count ++;
            }
        }
        return count;
    }

}
