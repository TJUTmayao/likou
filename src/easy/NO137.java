package easy;

/**
 * @ClassName NO137
 * @Description 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/13 15:26
 */
public class NO137 {
    public String tree2str(TreeNode t) {
        StringBuilder builder = new StringBuilder();
        digui(t,builder);
        return builder.toString();
    }

    public void digui(TreeNode t,StringBuilder stringBuilder){
        if (t == null){
            return;
        }
        stringBuilder.append(t.val);
        if (t.left != null || t.right != null){
            stringBuilder.append("(");
            digui(t.left,stringBuilder);
            stringBuilder.append(")");
            if (t.right != null){
                stringBuilder.append("(");
                digui(t.right,stringBuilder);
                stringBuilder.append(")");
            }
        }
    }
}
