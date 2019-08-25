package easy;

import java.util.ArrayList;

/**
 * @ClassName NO163
 * @Description 不使用任何内建的哈希表库设计一个哈希映射
 *
 * 具体地说，你的设计应该包含以下的功能
 *
 * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 * remove(key)：如果映射中存在这个键，删除这个数值对。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashmap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/22 18:13
 */
public class NO163 {
}
class MyHashMap {

    private ArrayList<Node>[] lists;
    /** Initialize your data structure here. */
    public MyHashMap() {
        lists = new ArrayList[15625];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = hashCode(key);
        ArrayList<Node> list = lists[i];
        if (list == null){
            list =  new ArrayList(32);
            list.add(new Node(key,value));
            lists[i] = list;
        }else {
            for (Node node : list) {
                if (node.key == key){
                    node.value = value;
                    return;
                }
            }
            list.add(new Node(key,value));
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = hashCode(key);
        ArrayList<Node> list = lists[i];
        if (list != null){
            for (Node node : list) {
                if (node.key == key){
                    return node.value;
                }
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = hashCode(key);
        ArrayList<Node> list = lists[i];
        if (list != null){
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).key == key){
                    list.remove(j);
                    return;
                }
            }
        }
    }

    public int hashCode(int key){
        return key >> 6;
    }
    private class Node{
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        int key;
        int value;
    }
}
