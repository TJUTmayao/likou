package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName NO30
 * @Description 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
                在杨辉三角中，每个数是它左上方和右上方的数的和。
 * @Author 11432
 * @DATE 2019/7/8 10:34
 */
public class NO30 {

    public static void main(String[] args) {
        System.out.println(getRow2(4));
    }

    /** 使用的容器 不合适 */
    public static List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        if (rowIndex == 0){
            return list;
        }
        list.add(1);
        if (rowIndex == 1){
            return list;
        }
        int casual;
        for (int i = 2; i <= rowIndex; i++) {
            casual = 1;
            for (int j = 1; j < i; j++) {
                int newInt = casual + list.get(j);
                casual = list.get(j);
                if (j < i - 1){
                    list.set(j,newInt);
                }else {
                    list.add(list.size() - 1,newInt);
                }
            }
        }
        return list;
    }


    /** 选用适合频繁修改的链表 */
    public static List<Integer> getRow2(int rowIndex) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        if (rowIndex == 0){
            return list;
        }
        list.add(1);
        if (rowIndex == 1){
            return list;
        }
        for (int i = 2; i <= rowIndex; i++) {
            Integer last = list.poll();
            for (int j = 1; j < i; j++) {
                int newInt = last + list.peek();
                last = newInt - last;
                list.add(newInt);
                if (j < i - 1){
                    list.poll();
                }
            }
            list.add(1);
        }
        return list;
    }

    /** 巧解 */
    public static List<Integer> getRow3(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        if (rowIndex == 0){
            return list;
        }
        list.add(1);
        if (rowIndex == 1){
            return list;
        }
        for (int i = 2; i <= rowIndex; i++) {
           list.add(1);
            for (int j = i - 1; j >= 1; j--) {
                list.set(j,list.get(j) + list.get(j - 1));
            }
        }
        return list;
    }

}
