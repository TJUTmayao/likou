package easy;

import Utils.ArrayUtil;

/**
 * @ClassName NO8
 * @Description 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * @Author 11432
 * @DATE 2019/6/9 8:41
 */
public class NO8 {

    public static void main(String[] args) {
        System.out.println(getNotRepetition(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public static int getNotRepetition(int[] nums){
        int notRepetitionIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[notRepetitionIndex]){
                nums[notRepetitionIndex + 1] = nums[i];
                notRepetitionIndex ++;
            }
        }
        return notRepetitionIndex + 1;
    }


}
