package easy;

/**
 * @ClassName NO56
 * @Description 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * @Author 11432
 * @DATE 2019/7/17 12:35
 */
public class NO56 {
    public static void main(String[] args) {
        NO56 no56 = new NO56();
        System.out.println(no56);
    }

    /** 不牛逼的解法 */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0){
            return false;
        }
        boolean flag = false;
        while (n != 0){
            if ((n & 1) == 1){
                if (flag){
                    return false;
                }
                flag = true;
            }
            n = n >> 1;
        }
        return true;
    }
    /** 牛逼的解法 */
    public boolean isPowerOfTwo2(int n) {
        if(n <= 0){
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
