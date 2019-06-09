package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName NO1
 * @Description 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * @Author 11432
 * @DATE 2019/6/7 19:23
 */
public class NO1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> ints = new ArrayList<>();
        for (int i = 0;i < 10; i++){
            int anInt = scanner.nextInt();
            ints.add(anInt);
        }
        int target = scanner.nextInt();
    }

    /** hash法  只能使用HashMap？ 因为hash冲突和数值可能过大 */
    public static int[] test(int[] nums,int target){
        Map<Integer,Integer> hashTable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashTable.containsKey(target - nums[i])){
                Integer integer = hashTable.get(target - nums[i]);
                if (integer != i){
                    return new int[]{i,integer};
                }
            }
            hashTable.put(nums[i],i);
        }
        throw new RuntimeException("不存在此数");
    }


    /** 暴力法 */
    public static int[] test1(int[] nums,int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}
