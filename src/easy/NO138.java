package easy;

/**
 * @ClassName NO138
 * @Description 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
 * 否则不为 NULL 的节点将直接作为新二叉树的节点
 *
 * @Author 11432
 * @DATE 2019/8/13 15:50
 */
public class NO138 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null){
            return null;
        }
        TreeNode newNode;
        if (t1 != null && t2 != null){
            newNode = new TreeNode(t1.val + t2.val);
            newNode.left = mergeTrees(t1.left,t2.left);
            newNode.right = mergeTrees(t1.right,t2.right);
        }else {
            if (t1 == null){
                newNode = new TreeNode(t2.val);
                newNode.left = mergeTrees(null,t2.left);
                newNode.right = mergeTrees(null,t2.right);
            }else {
                newNode = new TreeNode(t1.val);
                newNode.left = mergeTrees(t1.left,null);
                newNode.right = mergeTrees(t1.right,null);
            }
        }
        return newNode;
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        // 若有一边为空，则直接把不为空的树的剩余部分直接拼接到合并后的树上
        if (t1 == null){
            return t2;
        }else if (t2 == null){
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees2(t1.left,t2.left);
        t1.right = mergeTrees2(t1.right,t2.right);
        return t1;
    }

}
