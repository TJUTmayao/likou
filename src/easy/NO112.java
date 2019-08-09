package easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName NO112
 * @Description 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（
 * "Gold Medal", "Silver Medal", "Bronze Medal"）。
 *
 * (注：分数越高的选手，排名越靠前。)
 *
 * @Author 11432
 * @DATE 2019/8/6 17:42
 */
public class NO112 {

    public static void main(String[] args) {
        NO112 no112 = new NO112();
        no112.findRelativeRanks3(new int[]{10,3,8,9,4});
    }
    public static String[] findRelativeRanks(int[] nums) {
        int[] ints = new int[nums.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = -1;
        }
        String[] strings = new String[nums.length];
        int min;
        int size = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            min = 0;
            while (min <= size){
                if (ints[min] != -1 && nums[i] < nums[ints[min]]){
                    break;
                }
                min ++;
            }
            if (min > 0){
                min --;
                for (int j = 0; j < min; j++) {
                    ints[j] = ints[j + 1];
                }
                ints[min] = i;
            }
        }
        if (ints[size] != -1){
            strings[ints[size --]] = "Gold Medal";
        }
        if (size >= 0){
            strings[ints[size --]] = "Silver Medal";
        }
        if (size >= 0){
            strings[ints[size --]] = "Bronze Medal";
        }
        for (int i = size; i >= 0; i--) {
             strings[ints[i]] = (ints.length - i) + "";
        }
        return strings;
    }

    /** 排序 + hash表 */
    public String[] findRelativeRanks2(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        quickSort(nums,0,nums.length - 1);
        if (nums.length - 1 >= 0){
            strings[map.get(nums[nums.length - 1])] = "Gold Medal";
        }
        if (nums.length - 2 >= 0){
            strings[map.get(nums[nums.length - 2])] = "Silver Medal";
        }
        if (nums.length - 3 >= 0){
            strings[map.get(nums[nums.length - 3])] = "Bronze Medal";
        }
        for (int i = nums.length - 4; i >= 0; i--) {
            int k = nums.length - i;
            strings[map.get(nums[i])] = "" + k;
        }
        return strings;
    }

    public void quickSort(int[] nums,int left,int right){
        if (left >= right){
            return;
        }
        int move = move(nums, left, right);
        quickSort(nums,left,move - 1);
        quickSort(nums,move + 1,right);
    }

    public int move(int[] nums,int left,int right){
        int mid = nums[right];
        int j = left;
        for (int i = left; i < right; i++) {
            if (nums[i] <= mid){
                int k = nums[i];
                nums[i] = nums[j];
                nums[j++] = k;
            }
        }
        nums[right] = nums[j];
        nums[j] = mid;
        return j;
    }

    /** 排序 + 记录 改进排序:在排序时记录下标变化 */
    public String[] findRelativeRanks3(int[] nums){
        String[] strings = new String[nums.length];
        int[] ints = new int[nums.length];
        int length = nums.length;
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }
        quickSort_2(nums,ints,0,nums.length - 1);
        for (int i = length - 1; i >= 0; i--) {
            strings[ints[i]] = getRank(length - i);
        }
        return strings;
    }
    public void quickSort_2(int[] nums,int[] indexs,int start,int end){
        if (start >= end){
            return;
        }
        int i = sort_2(nums, indexs, start, end);
        quickSort_2(nums,indexs,start,i - 1);
        quickSort_2(nums,indexs,i + 1,end);
    }

    public int sort_2(int[] nums,int[] indexs,int start,int end){
        int j = start;
        int k;
        for (int i = start; i < end; i++) {
            if (nums[i] <= nums[end]){
                k = nums[i];
                nums[i] = nums[j];
                nums[j] = k;
                k = indexs[i];
                indexs[i] = indexs[j];
                indexs[j] = k;
                j++;
            }
        }
        k = nums[end];
        nums[end] = nums[j];
        nums[j] = k;
        k = indexs[j];
        indexs[j] = indexs[end];
        indexs[end] = k;
        return j;
    }

    public String getRank(int x){
        switch (x){
            case 1:
                return "Gold Medal";
            case 2:
                return "Silver Medal";
            case 3:
                return "Bronze Medal";
                default:
                    return String.valueOf(x);
        }
    }
}
