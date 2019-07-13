package easy;

/**
 * @ClassName NO38
 * @Description 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * @Author 11432
 * @DATE 2019/7/12 16:07
 */
public class NO38 {
    /** 暴力法 */
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target){
                    return new int[]{i + 1,j + 1};
                }
            }
        }
        return new int[0];
    }

    /** 双指针法 */
    public int[] twoSum1(int[] numbers, int target) {
        int num;
        for (int i = 0,j = numbers.length - 1; i < j;) {
            num = numbers[i] + numbers[j];
            if (num == target){
                return new int[]{i + 1,j + 1};
            }
            if(num < target){
                i ++;
            }else{
                j --;
            }
        }
        return new int[0];
    }
}
