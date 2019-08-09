package easy;

/**
 * @ClassName NO119
 * @Description 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * @Author 11432
 * @DATE 2019/8/9 15:49
 */

/** 善用全局变量 ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！*/
public class NO119 {
    public TreeNode convertBST(TreeNode root) {
        digui(root,0);
        return root;
    }

    public int digui(TreeNode root,int val){
        if (root == null){
            return val;
        }
        int digui = digui(root.right,val);
        root.val = root.val + digui;
        return digui(root.left,root.val);
    }

    private int num = 0;
    public TreeNode convertBST2(TreeNode root) {
        digui2(root);
        return root;
    }

    public void digui2(TreeNode root){
        if (root == null){
            return;
        }
        digui2(root.right);
        num += root.val;
        root.val = num;
        digui2(root.left);
    }
}
