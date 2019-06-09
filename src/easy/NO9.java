package easy;

import Utils.ArrayUtil;

/**
 * @ClassName NO9
 * @Description TODO
 * @Author 11432
 * @DATE 2019/6/9 9:10
 */
public class NO9 {

    public static void main(String[] args) {
        System.out.println(removeValOnArray(new int[]{3,2,2,3},3));
    }
    public static int removeValOnArray(int[] nums,int val){
        int end = nums.length - 1;
        int i;
        for (i = 0; i <= end;) {
            if (nums[i] == val){
                nums[i] = nums[end --];
            }else {
                i ++;
            }
        }
        ArrayUtil.showInts(nums);
        return i;
    }
}
