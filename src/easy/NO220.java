package easy;

/**
 * @ClassName NO220
 * @Description 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 *
 * 二叉搜索树保证具有唯一的值。
 * @Author 11432
 * @DATE 2019/9/18 16:55
 */
public class NO220 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null){
            return 0;
        }
        if (root.val >= L && root.val <= R){
            return root.val + rangeSumBST(root.left,L,R) + rangeSumBST(root.right,L,R);
        }
        /** 只剩下 大于R 或 小于L 的节点*/
        if (root.val < L){
            return rangeSumBST(root.right,L,R);
        }else {
            return rangeSumBST(root.left,L,R);
        }
    }
}
