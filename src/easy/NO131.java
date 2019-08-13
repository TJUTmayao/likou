package easy;

/**
 * @ClassName NO131
 * @Description 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 你找到的子数组应是最短的，请输出它的长度。
 * @Author 11432
 * @DATE 2019/8/11 16:55
 */
public class NO131 {
    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2,1}));
    }
    public static int findUnsortedSubarray(int[] nums) {
        int x,y;
        // 找到 从0开始递增的终点 和 从数组末尾递减的终点
        for (x = 0,y = nums.length - 1; x < y;) {
            if (nums[x] > nums[x + 1] && nums[y] < nums[y - 1]){
                break;
            }else {
                if (nums[x] <= nums[x + 1]){
                    x++;
                }
                if (nums[y] >= nums[y - 1]){
                    y--;
                }
            }
        }
        // 找到无序连续子数组的最小值和最大值
        int min = Math.min(nums[x],nums[y]);
        int max = Math.max(nums[x],nums[y]);
        for (int i = x + 1; i < y; i++) {
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        // 保证子数组左边的值都小于 子数组的最小元素，同时更新数组最大值（因为子数组左边是递增，其值可能大于子数组最大值），
        // 最小值无需更新，因为每次进来的数一定大于最小值
        while (x >= 0 && nums[x] > min){
            max = Math.max(max,nums[x]);
            x --;
        }
        // 保证子数组右边的值都大于 子数组的最大元素，同时更新数组最小值（因为子数组右边是递减，其值可能小于子数组最小值）
        // 最大值无需更新，因为每次进来的数一定小于最大值（没用）
        while (y < nums.length && nums[y] < max){
            min = Math.min(min,nums[y]);
            y ++;
        }
        int k = Math.abs(x - y) - 1;
        return k > 0 ? k: 0;
    }

    public static int findUnsortedSubarray2(int[] nums) {
        int x = 0,y = 0;
        int min = nums[nums.length - 1];
        int max = nums[0];
        for (int i = 0,j = nums.length - 1; i < j; i++,j--) {
            // 找到最后一个不符合递增规律的元素的位置
            max = Math.max(max,nums[i]);
            // 找到最后一个不符合递减规律的元素的位置
            min = Math.min(min,nums[j]);
            if (nums[i] < max){
                x = i;
            }
            if (nums[j] > min){
                y = j;
            }
        }
        // 这两个元素之间为最短无序连续子数组
        return y - x + 1;
    }
}
