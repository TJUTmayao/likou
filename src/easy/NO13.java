package easy;

import java.util.zip.Checksum;

/**
 * @ClassName NO13
 * @Description (动态规划)给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @Author 11432
 * @DATE 2019/6/22 10:19
 */
public class NO13 {

    public static int maxSubArray(int[] nums){
        int max = Integer.MIN_VALUE;
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (num < 0){
                num = nums[i];
            }else {
                num += nums[i];
            }
            if (num > max){
                max = num;
            }
        }
        return max;
    }
}
