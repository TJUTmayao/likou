package easy;

/**
 * @ClassName NO21
 * @Description 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * @Author 11432
 * @DATE 2019/7/6 9:03
 */
public class NO21 {
    /** 比较结构--深度优先搜索 */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null){
            if (p == q){
                return true;
            }
            return false;
        }
        if (p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
