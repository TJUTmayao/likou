package easy;

/**
 * @ClassName NO111
 * @Description 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *              你可以假设数组中无重复元素
 * @Author 11432
 * @DATE 2019/6/9 18:19
 */
public class NO11 {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,7},1));
    }

    /** 二分查找 */
    public static int searchInsert(int[] nums, int target){
        int start = 0,end = nums.length - 1;
        int i = end / 2;
        for (;start < end;){
            if (nums[i] == target){
                return i;
            }
            if (nums[i] > target){
                end = i - 1;
            }
            if (nums[i] < target){
                start = i + 1;
            }
            i = start + (end -  start) / 2;
        }
        return nums[i] >= target ? i : i + 1;
    }
}
