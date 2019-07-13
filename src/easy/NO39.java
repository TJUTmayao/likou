package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName NO39
 * @Description 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *
 * @Author 11432
 * @DATE 2019/7/12 16:34
 */
public class NO39 {

    /** 等同于10 转 26进制 但有些不同 */
    public String convertToTitle(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        while (n / 26 > 0){
            int i = n % 26;
            list.add(i);
            n = n / 26;
            if (i == 0){
                n -= 1;
            }
        }
        if (n != 0){
            list.add(n);
        }
        for (int i = list.size() - 1; i >= 0 ; i--) {
            if (list.get(i) == 0){
                stringBuilder.append("Z");
            }else {
                stringBuilder.append((char)(list.get(i)+'@'));
            }
        }
        return stringBuilder.toString();
    }


}
