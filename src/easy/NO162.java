package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName NO162
 * @Description 不使用任何内建的哈希表库设计一个哈希集合
 *
 * 具体地说，你的设计应该包含以下的功能
 *
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/22 17:47
 */
public class NO162 {
}
class MyHashSet {

    private ArrayList<Integer>[] lists;

    /** Initialize your data structure here. */
    public MyHashSet() {
        lists = new ArrayList[15625];
    }

    public void add(int key) {
        int i = getHashCode(key);
        ArrayList<Integer> list = lists[i];
        if (list == null){
            list = new ArrayList<>(10);
            lists[i] = list;
        }
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j) == key){
                return;
            }
        }
        list.add(key);
    }

    public void remove(int key) {
        int i = getHashCode(key);
        ArrayList<Integer> list = lists[i];
        if (list != null){
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == key){
                    list.remove(j);
                    return;
                }
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int i = getHashCode(key);
        ArrayList<Integer> list = lists[i];
        if (list != null){
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == key){
                    return true;
                }
            }
        }
        return false;
    }

    public int getHashCode(int key){
        return key >> 6;
    }
}
