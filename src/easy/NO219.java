package easy;

import java.lang.String;
import other.Test;

import java.util.*;

/**
 * @ClassName NO219
 * @Description 你有一个日志数组 logs。每条日志都是以空格分隔的字串。
 *
 * 对于每条日志，其第一个字为字母数字标识符。然后，要么：
 *
 * 标识符后面的每个字将仅由小写字母组成，或；
 * 标识符后面的每个字将仅由数字组成。
 * 我们将这两种日志分别称为字母日志和数字日志。保证每个日志在其标识符后面至少有一个字。
 *
 * 将日志重新排序，使得所有字母日志都排在数字日志之前。字母日志按内容字母顺序排序，忽略标识符；在内容相同时，按标识符排序。数字日志应该按原来的顺序排列。
 *
 * 返回日志的最终顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-log-files
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/18 14:33
 */
public class NO219 {
    public static void main(String[] args) {
        NO219 no219 = new NO219();
        System.out.println(no219.reorderLogFiles2(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"}));
    }
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (String o1,String o2) -> {
            String[] split_1 = o1.split(" ", 2);
            String[] split_2 = o2.split(" ", 2);
            boolean isNum_1 = isNumber(split_1[1].charAt(0));
            boolean isNum_2 = isNumber(split_2[1].charAt(0));
            if (isNum_1 || isNum_2){
                if (isNum_1 && isNum_2){
                    return 0;
                }
                return isNum_1 ? 1 : -1;
            }
            int compare = split_1[1].compareTo(split_2[1]);
            if (compare == 0){
                return split_1[0].compareTo(split_2[0]);
            }
            return compare;
        });
        return logs;
    }

    public boolean isNumber(char c){
        return c >= 48 && c <= 57;
    }

    /** String.compareTo() ：先比每个字符（最短长度），再比长度*/
    public String[] reorderLogFiles2(String[] logs) {
        ArrayList<String> numberList = new ArrayList<>();
        ArrayList<String> letterList = new ArrayList<>();
        for (String log : logs) {
            int i = log.indexOf(" ") + 1;
            if (isNumber(log.charAt(i))){
                numberList.add(log);
            }else {
                letterList.add(log.substring(i) + " " +log.substring(0,i - 1));
            }
        }
        Collections.sort(letterList);
        int x = 0;
        for (int i = 0; i < letterList.size(); i++) {
            String string = letterList.get(i);
            int k = string.lastIndexOf(" ") + 1;
            logs[x ++] = string.substring(k)+ " " + string.substring(0,k - 1);
        }
        for (int i = 0; i < numberList.size(); i++) {
            logs[x++] = numberList.get(i);
        }
        return logs;
    }
}
