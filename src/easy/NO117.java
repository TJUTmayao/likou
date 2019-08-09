package easy;

/**
 * @ClassName NO117
 * @Description 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 * @Author 11432
 * @DATE 2019/8/7 17:05
 */
public class NO117 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(7);
        node.right = node3;
        node3.left = node2;
        NO117 no117 = new NO117();
        System.out.println(no117.getMinimumDifference(node));
    }

    private TreeNode last = null;
    public int getMinimumDifference(TreeNode root) {
        if (root == null){
            return Integer.MAX_VALUE;
        }
        int min = getMinimumDifference(root.left);
        if (last != null){
            int k = Math.abs(last.val - root.val);
            min = min < k ? min : k;
        }
        last = root;
        int digui = getMinimumDifference(root.right);
        return min > digui ? digui : min;
    }

}
