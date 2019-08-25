package easy;

/**
 * @ClassName NO156
 * @Description 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 * @Author 11432
 * @DATE 2019/8/21 15:18
 */
public class NO156 {
    public boolean hasAlternatingBits(int n) {
        while (n != 0){
            int x = n >> 1;
            if (x != 0 && ((n & 1) ^ (x & 1)) != 1){
                return false;
            }
            n = x;
        }
        return true;
    }
}
