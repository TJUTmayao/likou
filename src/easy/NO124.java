package easy;

/**
 * @ClassName NO124
 * @Description 四叉树是一种树数据，其中每个结点恰好有四个子结点：topLeft、topRight、bottomLeft 和 bottomRight。
 * 四叉树通常被用来划分一个二维空间，递归地将其细分为四个象限或区域。
 * 我们希望在四叉树中存储 True/False 信息。四叉树用来表示 N * N 的布尔网格。
 * 对于每个结点, 它将被等分成四个孩子结点直到这个区域内的值都是相同的。
 * 每个节点都有另外两个布尔属性：isLeaf 和 val。当这个节点是一个叶子结点时 isLeaf 为真。val 变量储存叶子结点所代表的区域的值。
 *
 * @Author 11432
 * @DATE 2019/8/10 15:16
 */
public class NO124{

    public Node4 intersect(Node4 quadTree1, Node4 quadTree2) {
        // 其中一个是叶子结点
        if (quadTree1.isLeaf || quadTree2.isLeaf){
            // 都是叶子结点，直接返回两者val的 或 的结果
            if (quadTree1.isLeaf && quadTree2.isLeaf){
                return new Node4(quadTree1.val || quadTree2.val,true,null,null,null,null);
            }
            // quadTree1是叶子节
            else if (quadTree1.isLeaf){
                // 若其val为true，则合并后该节点为true且无子节点
                if (quadTree1.val){
                    return new Node4(true,true,null,null,null,null);
                }
                // 若其val为false，则保留有叶子结点的一方
                else {
                    return quadTree2;
                }
            }
            // 同上
            else if (quadTree2.isLeaf){
                if (quadTree2.val){
                    return new Node4(true,true,null,null,null,null);
                }else {
                    return quadTree1;
                }
            }
        }
        // 若两个节点都不是叶节点，向下遍历
        else {
            Node4 intersect1 = intersect(quadTree1.topLeft, quadTree2.topLeft);
            Node4 intersect2 = intersect(quadTree1.topRight,quadTree2.topRight);
            Node4 intersect3 = intersect(quadTree1.bottomLeft,quadTree2.bottomLeft);
            Node4 intersect4 = intersect(quadTree1.bottomRight,quadTree2.bottomRight);
            // 若返回的四个节点的val相同，并且这四个节点都是叶节点，则合并这四个节点
            boolean b = intersect1.val == intersect2.val && intersect1.val == intersect3.val && intersect1.val == intersect4.val;
            b = b && intersect1.isLeaf && intersect2.isLeaf && intersect3.isLeaf && intersect4.isLeaf;
            if (b){
                return new Node4(intersect1.val,true,null,null,null,null);
            }
            // 否则将这四个子节点付给父节点
            else {
                return new Node4(false,false,intersect1,intersect2,intersect3,intersect4);
            }
        }
        return null;
    }
}
class Node4 {
    public boolean val;
    public boolean isLeaf;
    public Node4 topLeft;
    public Node4 topRight;
    public Node4 bottomLeft;
    public Node4 bottomRight;

    public Node4() {}

    public Node4(boolean _val,boolean _isLeaf,Node4 _topLeft,Node4 _topRight,Node4 _bottomLeft,Node4 _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}

//{"$id":"1",
//        "bottomLeft":{"$id":"4","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":true},
//        "bottomRight":{"$id":"5","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":false},
//        "isLeaf":false,
//        "topLeft":{"$id":"2","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":true},
//        "topRight":{"$id":"3","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":true},
//        "val":false}
//
//        {"$id":"1",
//        "bottomLeft":{"$id":"4","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":false},
//        "bottomRight":{"$id":"5","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":false},
//        "isLeaf":false,
//        "topLeft":{"$id":"2","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":true},
//        "topRight":{"$id":"3","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":true},
//        "val":true}
//
//        {"$id":"1",
//        "bottomLeft":{"$id":"8","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":true},
//        "bottomRight":{"$id":"9","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":false},
//        "isLeaf":false,"topLeft":{"$id":"2","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":true},
//        "topRight":{"$id":"3","bottomLeft":{"$id":"6","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":true},
//        "bottomRight":{"$id":"7","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":true},
//        "isLeaf":false,"topLeft":{"$id":"4","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":false},
//        "topRight":{"$id":"5","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":false},
//        "val":true},
//        "val":true}