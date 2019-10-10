package easy;

/**
 * @ClassName NO227
 * @Description 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 *
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * @Author 11432
 * @DATE 2019/9/21 18:59
 */
public class NO227 {
    private TreeNode last;
    public boolean isUnivalTree(TreeNode root) {
        if (root == null){return true;}
        boolean is = true;
        is = is && isUnivalTree(root.left);
        if (last != null){
            is = root.val == last.val && is;
        }
        last = root;
        is = is && isUnivalTree(root.right);
        return is;
    }
}
