package easy;

/**
 * @ClassName NO173
 * @Description 在一个给定的数组nums中，总是存在一个最大元素 。
 *
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 *
 * 如果是，则返回最大元素的索引，否则返回-1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/27 15:41
 */
public class NO173 {
    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{0,0,3,2}));
    }
    public static int dominantIndex(int[] nums) {
        int max = -1;
        int sec = -1;
        for (int i = 0; i < nums.length; i++) {
            if (max == -1 || nums[max] < nums[i]){
                sec = max;
                max = i;
            }else if (sec == -1 || nums[sec] < nums[i]){
                sec = i;
            }
        }
        if (sec < 0 || nums[sec] == 0){
            return max;
        }
        return nums[max] / nums[sec] >= 2 ? max : -1;
    }
}
