package easy;

/**
 * @ClassName NO92
 * @Description 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * @Author 11432
 * @DATE 2019/7/27 15:45
 */
public class NO92 {
    private int num = 0;
    public int pathSum(TreeNode root, int sum) {
         if (root == null){
             return 0;
         }
         digui(root,sum,0,false);
         return this.num;
    }

    public void digui(TreeNode root,int num,int he,boolean isZero){
        if (root.val + he == num){
            this.num ++;
        }
        he += root.val;
        if (root.left != null){
            digui(root.left,num,he,true);
            if (!isZero){
                digui(root.left,num,0,false);
            }
        }
        if (root.right != null){
            digui(root.right,num,he,true);
            if (!isZero){
                digui(root.right,num,0,false);
            }
        }
    }
}
