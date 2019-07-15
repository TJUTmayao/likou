import java.util.HashSet;
import java.util.Map;

/**
 * @ClassName Dijkstra2
 * @Description 迪杰斯特拉算法 邻接矩阵 成功
 * @Author 11432
 * @DATE 2019/7/15 16:56
 */
public class Dijkstra2 {

    private static final int M = 99999;

    public static void main(String[] args) {
        int[][] weight1 = {
                {0,4,M,2,M},
                {4,0,4,1,M},
                {M,4,0,1,3},
                {2,1,1,0,7},
                {M,M,3,7,0}
        };
        int[] shortestPath = getShortestPath(weight1, 3);
        for (int i = 0; i < shortestPath.length; i++) {
            System.out.println(shortestPath[i] + "\t");
        }
    }

    /** 最短路径算法 贪心算法 */
    public static int[] getShortestPath(int[][] matrix,int start){
        int min;
        int cMinIndex = start;
        // 未寻路节点
        boolean[] U = new boolean[matrix.length];
        // 已寻路节点
        boolean[] S = new boolean[matrix.length];
        // 目前最短
        int[] D = new int[matrix.length];
        S[start] = true;
        for (int i = 0; i < U.length; i++) {
            if (i == start){
                continue;
            }
            U[i] = true;
        }
        // 初始化 D
        for (int i = 0; i < D.length; i++) {
            D[i] = M;
        }
        int minIndex = start;
        int lastMin = 0;
        for (int i = 0; i < matrix.length; i++) {
            min = M;
            for (int j = 0; j < matrix[minIndex].length; j++) {
                if (!U[j] || matrix[minIndex][j] == M){
                    continue;
                }
                // 先比较最后进入S的点 X 到其所连接的各节点的距离 和 （起点到 X所连接的各节点的距离 + 起点到X的最短距离），取二者中最小的MIN。
                int s = matrix[minIndex][j] + lastMin > matrix[start][j] ? matrix[start][j] : matrix[minIndex][j] + lastMin;
                // 再比较 X 没进入S前到 X所连接的各节点 的距离 和 MIN，取其小者。
                D[j] = s > D[j] ? D[j] : s;
                if (min > D[j]){
                    min = D[j];
                    cMinIndex = j;
                }
            }
            lastMin = min;
            minIndex = cMinIndex;
            U[minIndex] = false;
            S[minIndex] = true;
        }
        return D;
    }

    /** 邻接表转邻接矩阵 */
    public int[][] getMatrix(Node start){
        HashSet<Node> nodes = new HashSet<>();
        nodes.add(start);
        // 获取所有节点
        for (Node node : nodes){
            for (Node s : node.map.keySet()){
                nodes.add(s);
            }
        }
        int[][] matrix = new int[nodes.size()][nodes.size()];
        // 初始化邻接矩阵
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = 0; j < nodes.size(); j++) {
                matrix[i][j] = M;
            }
        }
        // 转换
        for (Node node : nodes) {
            for (Map.Entry<Node,Integer> entry : node.map.entrySet()){
                matrix[node.key][entry.getKey().key] = entry.getValue();
            }
        }
        return matrix;
    }

}
