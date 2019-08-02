package easy;

/**
 * @ClassName NO98
 * @Description 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动可以使 n - 1 个元素增加 1。
 * @Author 11432
 * @DATE 2019/8/1 14:38
 */
public class NO98 {

    public static void main(String[] args) {
        NO98 no98 = new NO98();
        System.out.println(no98.minMoves4(new int[]{1,2,3}));
    }
    /** 排序法 每次 +（max - min直到  max == min */
    public int minMoves(int[] nums) {
        quickSort(nums,0,nums.length - 1);
        int maxIndex = nums.length - 1;
        int i = 0;
        while (nums[0] + i != nums[maxIndex] + i){
            int k = nums[maxIndex] - nums[0];
            maxIndex --;
            i += k;
        }
        return i;
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
    /** -------------------------------------------------------------动态规划 ----------------------------------------------------------*/
    public int minMoves2(int[] nums) {
        quickSort(nums,0,nums.length - 1);
        int num = 0;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += num;
            num += nums[i] - nums[i - 1];
        }
        return num;
    }
    /** 数学法 n-1个加一 == 1个元素 减一 */
    public int minMoves3(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1]){
                num += nums[i + 1] - nums[i];
                nums[i + 1] = nums[i];
            }else {
                num += (nums[i] - nums[i + 1]) * (i + 1);
            }
        }
        return num;
    }
    /** 改进数学法 */
    public int minMoves4(int[] nums) {
        int num = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(nums[i],min);
            num += nums[i];
        }
        return num - min * nums.length;
    }
}
