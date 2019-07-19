package easy;

import java.util.HashMap;

/**
 * @ClassName NO53
 * @Description 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * @Author 11432
 * @DATE 2019/7/16 12:46
 */
public class NO53 {
    /** hash表 */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++) {
            if (map.containsKey(nums[i])){
                if (i - map.get(nums[i]) <= k){
                    return true;
                }
            }
            map.put(nums[i],i);
        }
        return false;
    }

    /** 时间复杂度n*k */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        int max=0;
        for(int i=1;i<nums.length;i++){
            // 找到递增终点
            if(nums[i]>nums[max]){
                max=i;
            }
            else{
                for(int j=i-1;j>=i-k && j>=0;j--){
                    if(nums[j]==nums[i]){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        int max=0;
        for(int i=1;i<nums.length;i++){
            for(int j=i-1;j>=i-k && j>=0;j--){
                if(nums[j]==nums[i]){
                    return true;
                }
            }
        }
        return false;
    }
}
