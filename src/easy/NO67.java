package easy;

import java.util.jar.JarEntry;

/**
 * @ClassName NO67
 * @Description 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *      必须在原数组上操作，不能拷贝额外的数组。
 *      尽量减少操作次数。
 * @Author 11432
 * @DATE 2019/7/19 16:46
 */
public class NO67 {
    /** 双指针 */
    public void moveZeroes(int[] nums) {
        for (int i = 0,j = 0; j < nums.length && i < nums.length;) {
            if (nums[i] != 0){
                i ++;
            }
            if (nums[j] == 0 || j < i){
                j ++;
            }
            else {
                nums[i] = nums[j];
                nums[j] = 0;
            }
        }
    }
}
