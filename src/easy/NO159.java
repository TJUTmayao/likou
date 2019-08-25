package easy;

/**
 * @ClassName NO159
 * @Description TODO
 * @Author 11432
 * @DATE 2019/8/22 14:39
 */
public class NO159 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return root;
        }
        TreeNode node = searchBST(root.left, val);
        if (node != null){
            return node;
        }
        if (root.val == val){
            return root;
        }
        return searchBST(root.right,val);
    }
}
