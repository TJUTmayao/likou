package easy;

/**
 * @ClassName No59
 * @Description 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * @Author 11432
 * @DATE 2019/7/17 16:20
 */
public class No59 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        TreeNode node = lowestCommonAncestor(root.left, p, q);
        TreeNode node1 = lowestCommonAncestor(root.right, p, q);
        if (node != null && node1 != null){
            return root;
        }
        if (root == p || root == q){
            return root;
        }
        return node == null ? node1 : node;
    }


    /** 优化版 */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        return digui(root,p.val,q.val);
    }

    public TreeNode digui(TreeNode root, int p, int q) {
        if (root.val > p && root.val > q){
            return digui(root.left,p,q);
        }
        if (root.val < p && root.val < q){
            return digui(root.right,p,q);
        }
        // 公共父节点的值一定在[p,q]的内,而公共父节点的父节点的值一定都大于或都小于 p，q
        return root;
    }

    /** 迭代版 */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        int valQ = q.val;
        int valP = p.val;
        while (true){
            if (root.val > valP && root.val > valQ){
                root = root.left;
                continue;
            }
            if (root.val < valP && root.val < valQ){
                root = root.right;
                continue;
            }
            return root;
        }
    }

}
