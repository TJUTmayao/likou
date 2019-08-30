package easy;

/**
 * @ClassName NO179
 * @Description 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 * @Author 11432
 * @DATE 2019/8/29 17:29
 */
public class NO179 {
    private int min = Integer.MAX_VALUE;
    private TreeNode last;
    public int minDiffInBST(TreeNode root) {
        digui(root);
        return min;
    }

    public void digui(TreeNode root){
        if (root == null){
            return;
        }
        digui(root.left);
        if (last != null){
            min = Math.min(root.val - last.val,min);
        }
        last = root;
        digui(root.right);
    }
}
