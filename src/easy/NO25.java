package easy;

/**
 * @ClassName NO25
 * @Description 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * @Author 11432
 * @DATE 2019/7/6 11:36
 */
public class NO25 {


    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length - 1);
    }
    /** 二分 + 递归 */
    public TreeNode helper(int[] nums,int start,int end) {
        if (start > end){
            return null;
        }
        int middle = start + ((end - start) >> 1);
        TreeNode root = new TreeNode(nums[middle]);
        root.left = helper(nums,start,middle - 1);
        root.right = helper(nums,middle + 1,end);
        return root;
    }
}
