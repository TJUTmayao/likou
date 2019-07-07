package easy;

/**
 * @ClassName NO26
 * @Description 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * @Author 11432
 * @DATE 2019/7/7 9:55
 */
public class NO26 {

    public boolean isBalanced(TreeNode root) {
        return isBalanced1(root) >= 0;
    }

    /** 递归版 */
    public int isBalanced1(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftHigh = isBalanced1(root.left);
        if (leftHigh == -1){return -1;}
        int rightHigh = isBalanced1(root.right);
        if (rightHigh == -1){return -1;}
        if (Math.abs(leftHigh - rightHigh) > 1){
            return -1;
        }
        return leftHigh >= rightHigh ? leftHigh + 1 : rightHigh + 1;
    }


}
