package easy;

/**
 * @ClassName NO55
 * @Description 翻转一棵二叉树。
 * @Author 11432
 * @DATE 2019/7/16 14:58
 */
public class NO55 {
    public TreeNode invertTree(TreeNode root) {
        digui(root);
        return root;
    }

    public void digui(TreeNode root){
        if (root == null){
            return;
        }
        digui(root.right);
        digui(root.left);
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
    }

    /** 优化版 */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode right = invertTree(root.left);
        TreeNode left = invertTree(root.right);
        root.left = left;
        root.right = right;
        return root;
    }
}
