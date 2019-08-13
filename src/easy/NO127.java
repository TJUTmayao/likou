package easy;

/**
 * @ClassName NO127
 * @Description 给定一个二叉树，计算整个树的坡度。
 *
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 *
 * 整个树的坡度就是其所有节点的坡度之和
 * @Author 11432
 * @DATE 2019/8/10 18:01
 */
public class NO127 {
    private int  num = 0;
    public int findTilt(TreeNode root) {
        digui(root);
        return num;
    }

    public int digui(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = digui(root.left);
        int right = digui(root.right);
        num += Math.abs(left - right);
        return root.val + left + right;
    }
}
