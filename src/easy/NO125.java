package easy;

/**
 * @ClassName NO125
 * @Description 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * @Author 11432
 * @DATE 2019/8/10 17:09
 */
public class NO125 {

//    public int maxDepth(Node root) {
//        if (root == null){
//            return 0;
//        }
//        final int[] max = {0};
//        root.children.forEach(node ->{
//            max[0] = Math.max(max[0],maxDepth(node));
//        });
//        return max[0] + 1;
//    }

    public int maxDepth(Node root) {
        if (root == null){
            return 0;
        }
        int max = 0;
        for (Node child : root.children) {
            max = Math.max(max,maxDepth(child));
        }
        return max + 1;
    }


}
