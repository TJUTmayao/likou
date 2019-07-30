package easy;

import java.util.Stack;

/**
 * @ClassName NO88
 * @Description 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * @Author 11432
 * @DATE 2019/7/26 17:07
 */
public class NO88 {

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{1,2,2,5,3,5}));
    }
    public static int thirdMax(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        int[] in = new int[3];
        for (int i = 1; i < nums.length; i++) {
            int k = 2;
            while (!stack.isEmpty() && stack.peek() < nums[i]){
                    in[k--] = stack.pop();
            }
            if (stack.size() < 3){
                if (!stack.isEmpty() && stack.peek() != nums[i]){
                    stack.push(nums[i]);
                }
                if (stack.isEmpty()){
                    stack.push(nums[i]);
                }
            }
            if (k < 2){
                for (int i1 = k + 1; i1 < 3 && stack.size() < 3; i1++) {
                    stack.push(in[i1]);
                }
            }
        }
        return stack.size() == 3 ? stack.peek() : stack.get(0);
    }

    public int thirdMax2(int[] nums) {
        quickSort(nums,0,nums.length - 1);
        int max = nums[nums.length - 1];
        int j = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < max){
                max = nums[i];
                j ++;
            }
            if (j == 3){
                break;
            }
        }
        return j == 3 ? max : nums[nums.length - 1];
    }


    public void quickSort(int[] nums,int start,int end){
        if (start >= end){
            return;
        }
        int sort = sort(nums, start, end);
        quickSort(nums,start,sort -1);
        quickSort(nums,sort + 1,end);
    }

    public int sort(int[] nums,int start,int end){
        int mis = nums[end];
        int j = 0;
        for (int i = start; i < end; i++) {
            if (nums[i] <= mis){
                int k = nums[j];
                nums[j] = nums[i];
                nums[i] = k;
                j ++;
            }
        }
        nums[end] = nums[j];
        nums[j] = mis;
        return j;
    }

    public int thirdMax3(int[] nums){
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (long num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second && num < first) {
                third = second;
                second = num;
            } else if (num > third && num < second) {
                third = num;
            }
        }
        if (third == Long.MIN_VALUE) {
            return (int) first;
        } else {
            return (int) third;
        }
    }

}
