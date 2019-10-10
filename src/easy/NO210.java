package easy;

/**
 * @ClassName NO210
 * @Description 给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 * @Author 11432
 * @DATE 2019/9/13 15:41
 */
public class NO210 {
    private TreeNode last = new TreeNode(-1);
    private TreeNode head = last;
    public TreeNode increasingBST(TreeNode root) {
        if (root == null){
            return null;
        }
        increasingBST(root.left);
        last.right = root;
        last = root;
        root.left = null;
        increasingBST(root.right);
        return head.right;
    }
}
