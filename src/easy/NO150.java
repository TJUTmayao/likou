package easy;

/**
 * @ClassName NO150
 * @Description 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * @Author 11432
 * @DATE 2019/8/16 18:16
 */
public class NO150 {
    public int findLengthOfLCIS(int[] nums) {
        int max = 0;
        if (nums.length == 0){
            return 0;
        }
        int i,j;
        for (i = 0,j = 1; j < nums.length; j++) {
            if (nums[j] <= nums[j - 1]){
                max = Math.max(j - i,max);
                i = j;
            }
        }
        return Math.max(j - i,max);
    }
}
