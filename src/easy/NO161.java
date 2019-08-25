package easy;

/**
 * @ClassName NO161
 * @Description 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/22 17:43
 */
public class NO161 {
    public int search(int[] nums, int target) {
        int L = 0,R = nums.length - 1;
        int mid;
        while (L <= R){
            mid = L + ((R - L) >> 1);
            if (nums[mid] > target){
                R = mid - 1;
            }else {
                if (nums[mid] == target){
                    return mid;
                }
                L = mid + 1;
            }
        }
        return -1;
    }
}
