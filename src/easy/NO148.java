package easy;

/**
 * @ClassName NO148
 * @Description 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。
 * 你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trim-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/16 17:20
 */
public class NO148 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        return digui(root,L,R,null);
    }
    public TreeNode digui(TreeNode root, int L, int R,TreeNode lastNode){
        if (root == null){
            return null;
        }
        if (root.val > R){
            TreeNode node = digui(root.left, L, R,root);
            set(node,lastNode,root);
            return node;
        }
        if (root.val < L){
            TreeNode node = digui(root.right, L, R,root);
            set(node,lastNode,root);
            return node;
        }
        root.left = digui(root.left, L, R,root);
        root.right = digui(root.right, L, R,root);
        return root;
    }

    public void set(TreeNode node,TreeNode lastNode,TreeNode root){
        if (lastNode != null){
            if (lastNode.val > root.val){
                lastNode.left = node;
            }else {
                lastNode.right = node;
            }
        }
    }
}
