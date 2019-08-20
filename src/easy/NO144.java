package easy;

/**
 * @ClassName NO144
 * @Description 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * @Author 11432
 * @DATE 2019/8/14 14:41
 */
public class NO144 {
    private TreeNode froot;
    public boolean findTarget(TreeNode root, int k) {
        froot = root;
        return digui2(root,k);
    }

    public boolean digui2(TreeNode root,int k){
        if (root == null){
            return false;
        }
        if (digui2(root.left,k) || digui(froot,root,k)){
            return true;
        }
        return digui2(root.right,k);
    }

    public boolean digui(TreeNode root,TreeNode node,int k){
        if (root == null){
            return false;
        }
        int i = node.val + root.val;
        if (i > k){
            return digui(root.left,node,k);
        }else{
            if (node == root){
                return digui(root.right,node,k);
            }
            return node.val + root.val == k || digui(root.right,node,k);
        }
    }
}
