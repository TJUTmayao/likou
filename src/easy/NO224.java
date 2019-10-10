package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName NO224
 * @Description 给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
 *
 * 最小的 24 小时制时间是 00:00，而最大的是 23:59。从 00:00 （午夜）开始算起，过得越久，时间越大。
 *
 * 以长度为 5 的字符串返回答案。如果不能确定有效时间，则返回空字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-time-for-given-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/19 15:45
 */
public class NO224 {

    public static void main(String[] args) {
        NO224 no224 = new NO224();
        System.out.println(no224.largestTimeFromDigits(new int[]{1,2,3,4}));
    }
    /** 数组全排列 */
    public String largestTimeFromDigits(int[] A) {
        return getTime(A);
    }

    public String getTime(int[] A) {
        // 下标和
        int add = 6;
        int maxHour = -1;
        int maxMinute = -1;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (j != i){
                    for (int k = 0; k < A.length; k++) {
                        if (k != i && k != j){
                            int s = add - k - i - j;
                            int hour = A[i] * 10 + A[j];
                            if (hour >= 24){
                                continue;
                            }
                            int minute = A[k] * 10 + A[s];
                            if (minute < 60){
                                if (maxHour < hour){
                                    maxHour = hour;
                                    maxMinute = minute;
                                }else if (hour == maxHour){
                                    maxMinute = Math.max(minute,maxMinute);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (maxHour != -1 && maxMinute != -1){
            return new StringBuilder().append(maxHour < 10 ? "0" + maxHour : maxHour).append(":").append(maxMinute < 10 ? "0" + maxMinute : maxMinute).toString();
        }else {
            return "";
        }
    }

}
