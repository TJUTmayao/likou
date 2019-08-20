package easy;

import java.util.List;

/**
 * @ClassName NO149
 * @Description 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 *              如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
 *              给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/16 17:54
 */
public class NO149 {

    public int findSecondMinimumValue(TreeNode root) {
        return digui(root,root.val);
    }

    public int digui(TreeNode root,int k){
        if (root == null){
            return -1;
        }
        if (root.val > k){
            return root.val;
        }
        int left = digui(root.left, k);
        int right = digui(root.right, k);
        if (left != -1 && right != -1){
            return Math.min(left,right);
        }
        return Math.max(left,right);
    }

}
