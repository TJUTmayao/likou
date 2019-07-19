package easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @ClassName NO52
 * @Description 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * @Author 11432
 * @DATE 2019/7/16 11:43
 */
public class NO52 {
    /** Hash表 */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (integers.contains(nums[i])){
                return true;
            }
            integers.add(nums[i]);
        }
        return false;
    }

    /** 先排序 再查找 */
    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]){
                return true;
            }
        }
        return false;
    }
    /** bitmap 空间换时间 投机取巧 只检查后20位 */
    public boolean containsDuplicate2(int[] nums) {
        boolean[] booleans_d = new boolean[1048576];
        for (int num : nums) {
            if (booleans_d[num & 1048575]){
                return true;
            }
            booleans_d[num & 1048575] = true;
        }
        return false;
    }
}
