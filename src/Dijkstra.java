import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Dijkstra
 * @Description 迪杰斯特拉算法 失败
 * @Author 11432
 * @DATE 2019/7/15 13:58
 */
public class Dijkstra {

    private static final int M = Integer.MAX_VALUE;

    public static void main(String[] args) {

    }

//    public List<Node> getShortestPath(Node start,Node end) {
//        // 未遍历到节点
//        ArrayList<Node> U = new ArrayList<>();
//        // 已求最短路径节点
//        ArrayList<Node> S = new ArrayList<>();
//        // 最短路径
//        List<Node> result = new ArrayList<>();
//        // 初始化 U
//        U.add(start);
//        for (int i = 0; i < U.size(); i++) {
//            Node node = U.get(i);
//            for (Node x : node.nextList) {
//                if (!U.contains(x)) {
//                    U.add(x);
//                }
//            }
//        }
//        U.remove(0);
//        int size = U.size();
//        int min = M;
//        Node thisNode;
//        int[] D = new int[size];
//        int[] D_1 = new int[size];
//        // 初始化 start 到个顶点的距离,和D
//        for (int i = 0; i < size; i++) {
//            D_1[i] = M;
//            D[i] = M;
//        }
//        for (Node node : start.nextList){
//            D_1[node.key] = node.token;
//        }
//        //  初始化 S
//        S.add(start);
//        result.add(start);
//        thisNode = start;
//        //先复制一遍D_1
//        // 开始寻路
//        min = 0;
//        int lastMin = 0;
//        for (int i = 0; i < size; i++) {
//            min = M;
//            List<Node> nextList = thisNode.nextList;
//            // 更新最短路径
//            for (Node node : nextList){
//                if (U.contains(node)){
//                    D[node.key] = node.token + lastMin > D_1[node.key] ? D_1[node.key] : node.token + lastMin;
//                    if (min > D[node.key]){
//                        min = D[node.key];
//                        thisNode = node;
//                    }
//                }
//            }
//            U.remove(thisNode);
//            S.add(thisNode);
//            lastMin = min;
//        }
//        return null;
//    }

}
class Node{
    int key;
    int token;
    HashMap<Node,Integer> map;

    public Node() {
        this.map = new HashMap<>();
    }

    public Node(int key, int token) {
        this();
        this.key = key;
        this.token = token;
    }

}
