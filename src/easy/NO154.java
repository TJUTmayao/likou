package easy;

/**
 * @ClassName NO154
 * @Description 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-univalue-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/20 17:23
 */
public class NO154 {
    private int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        digui(root);
        return max;
    }

    public int digui(TreeNode node){
        if (node == null){
            return 0;
        }
        int L = 0;
        int R = 0;
        if (node.left != null){
            L = digui(node.left);
            L = node.left.val == node.val ? L + 1 : L;
        }
        if (node.right != null){
            R = digui(node.right);
            R = node.right.val == node.val ? R + 1 : R;
        }
        max = Math.max(L + R ,max);
        return Math.max(L,R);
    }
}
