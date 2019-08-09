package easy;

/**
 * @ClassName NO106
 * @Description 给定一个二进制数组， 计算其中最大连续1的个数。
 * @Author 11432
 * @DATE 2019/8/5 10:40
 */
public class NO106 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int x = 0;
        for (int num : nums) {
            if (num == 0){
                if (x == 0){
                    continue;
                }
                max = max > x ? max : x;
                x = 0;
            }else {
                x++;
            }
        }
        return max > x ? max : x;
    }
}
