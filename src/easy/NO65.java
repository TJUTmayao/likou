package easy;

import java.util.Arrays;

/**
 * @ClassName NO65
 * @Description 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * @Author 11432
 * @DATE 2019/7/19 15:37
 */
public class NO65 {
    /** hash */
    public int missingNumber(int[] nums) {
        boolean[] booleans = new boolean[nums.length + 1];
        for (int num : nums) {
            booleans[num] = true;
        }
        for (int i = 0; i < booleans.length; i++) {
            if (!booleans[i]){
                return i;
            }
        }
        return 0;
    }

    /** 数学 */
    public int missingNumber2(int[] nums) {
        int num = 0;
        int i;
        for (i = 0; i < nums.length; i++) {
            num += i;
            num -= nums[i];
        }
        return num + i;
    }

    /** 排序 */
    public int missingNumber3(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }

    /** 位运算 A^A = 0 A^0 = A */
    public int missingNumber4(int[] nums) {
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            x = x ^ i ^ nums[i];
        }
        return (x ^ nums.length);
    }
}
