package easy;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName NO135
 * @Description 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 *
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 *
 * @Author 11432
 * @DATE 2019/8/12 18:05
 */
public class NO135 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i],i);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            Integer integer = map.get(list2[i]);
            if (integer != null){
                if (min > integer + i){
                    list.clear();
                    min = integer + i;
                }
                if (min == integer + i){
                    list.add(list2[i]);
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }
    public String[] findRestaurant2(String[] list1, String[] list2) {
        ArrayList<String> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])){
                    if (min > i + j){
                        min = i + j;
                        list.clear();
                    }
                    if (min == i + j){
                        list.add(list1[i]);
                    }
                    break;
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
