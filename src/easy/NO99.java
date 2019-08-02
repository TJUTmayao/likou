package easy;

/**
 * @ClassName NO99
 * @Description 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，
 * 都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，
 * 我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 * @Author 11432
 * @DATE 2019/8/2 10:27
 */
public class NO99 {

    /** 排序法 + 贪心 */
    public int findContentChildren(int[] g, int[] s) {
        quickSort(s,0,s.length - 1);
        quickSort(g,0,g.length - 1);
        int num = 0;
        for (int i = 0; i < s.length && num < g.length;i ++) {
            if (s[i] >= g[num]){
                num++;
            }
        }
        return num;
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
}
