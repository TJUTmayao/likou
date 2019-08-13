package easy;

/**
 * @ClassName NO129
 * @Description 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * @Author 11432
 * @DATE 2019/8/11 15:42
 */
public class NO129 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null){
            return false;
        }
        if (s.val == t.val && digui(s.left,t.left) && digui(s.right,t.right)){
            return true;
        }
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }
    public boolean digui(TreeNode s, TreeNode t){
        if (s == null && t == null){
            return true;
        }
        if (s == null || t == null){
            return false;
        }
        return s.val == t.val && digui(s.left,t.left) && digui(s.right,t.right);
    }
}
