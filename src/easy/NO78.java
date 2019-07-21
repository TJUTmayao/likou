package easy;

/**
 * @ClassName NO78
 * @Description 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 *
 * -1 : 我的数字比较小
 *  1 : 我的数字比较大
 *  0 : 恭喜！你猜对了！
 *
 * @Author 11432
 * @DATE 2019/7/21 17:16
 */
public class NO78 {

    public static void main(String[] args) {
        guessNumber(10);
    }
    /** 二分 */
    public static int guessNumber(int n) {
        int start = 1,end = n;
        int mid = 1;
        while (start <= end){
            mid = start + ((end - start) >> 1);
            int guess = guess(mid);
            if (guess == 1){
                start = mid + 1;
            }
            else if (guess == 0){
                return mid;
            }
            else if (guess == -1){
                end = mid - 1;
            }
        }
        return mid;
    }

    public static int guess(int n){
        if (n > 6){
            return 1;
        }
        return n == 6 ? 0 : -1;
    }
}
