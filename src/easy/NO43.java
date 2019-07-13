package easy;

/**
 * @ClassName NO43
 * @Description 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *              尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 *              要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * @Author 11432
 * @DATE 2019/7/13 17:14
 */
public class NO43 {

    public static void main(String[] args) {
        rotate4(new int[]{1,2,3,4,5,6,7},3);
        System.out.println();
    }

    /** 暴力法，每次移动一步  */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        for (int i = 0; i < k; i++) {
            int x = nums[0];
            nums[0] = nums[nums.length - 1];
            for (int j = 1; j < nums.length; j++) {
                int y = nums[j];
                nums[j] = x;
                x = y;
            }
        }
    }

    /** 环形移步 一次移动k % nums.length 步*/
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int last;
        int x,y;
        int count = 0;
        /** 共交换 nums.length 次 */
        for (int i = 0;count < nums.length; i ++) {
            // 指定交换起点
            int j = i;
            last = nums[i];
            // 每次交换后移动 k 步，环形移动
            do {
                y = (j + k) % nums.length;
                x = nums[y];
                nums[y] = last;
                last = x;
                j = y;
                count++;
            }while (j != i);//若回到起点，证明 数组长度与k 存在公因数 即会遍历到重复的位置
        }
    }

    /** 翻转法 */
    public void rotate3(int[] nums, int k) {
        int x;
        k = k % nums.length;
        // 翻转数组
        for (int i = 0,j = nums.length - 1; i < j ; i++,j--) {
            x = nums[i];
            nums[i] = nums[j];
            nums[j] = x;
        }
        // 将翻转后的数组的 前k个 再次翻转
        for (int i = 0,j = k - 1;i < j;i ++,j --){
            x = nums[i];
            nums[i] = nums[j];
            nums[j] = x;
        }
        // 将翻转后的数组的后 length - k 个再次翻转,得到目标数组
        for (int i = k,j = nums.length - 1;i < j;i ++,j --){
            x = nums[i];
            nums[i] = nums[j];
            nums[j] = x;
        }
    }

    /** 额外空间 */
    public static void rotate4(int[] nums, int k) {
        k = k % nums.length;
        int[] newInts = new int[nums.length];
        int m = k;
        for (int i = 0; i < nums.length - k; i++) {
            newInts[m++] = nums[i];
        }
        m = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            newInts[m++] = nums[i];
        }
        System.arraycopy(newInts,0,nums,0,nums.length);
    }
}
