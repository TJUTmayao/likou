package easy;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NO29
 * @Description 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *              在杨辉三角中，每个数是它左上方和右上方的数的和。
 * @Author 11432
 * @DATE 2019/7/7 12:54
 */
public class NO29 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>(numRows);
        if (numRows == 0){
            return lists;
        }
        ArrayList<Integer> list = new ArrayList<>(1);
        list.add(1);
        lists.add(list);
        for (int i = 2; i <= numRows; i++) {
            list = new ArrayList<>(i);
            list.add(1);
            if (i > 2){
                List<Integer> integers = lists.get(i - 2);
                for (int j = 1; j < i - 1; j++) {
                    list.add(integers.get(j - 1) + integers.get(j));
                }
            }
            list.add(1);
            lists.add(list);
        }
        return lists;
    }
}
