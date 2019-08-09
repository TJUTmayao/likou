package easy;

/**
 * @ClassName NO121
 * @Description 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 * @Author 11432
 * @DATE 2019/8/9 17:02
 */
public class NO121 {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        digui(root);
        return max;
    }
    public int digui(TreeNode root){
        if (root == null){
            return 0;
        }
        int x = digui(root.left);
        int y = digui(root.right);
        max = Math.max(x + y,max);
        return 1 + Math.max(x,y);
    }

    public static void main(String[] args) {
//        [4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]
    }
}
