package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName NO232
 * @Description 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/23 17:10
 */
public class NO232 {
    public static void main(String[] args) {
        new NO232().addToArrayForm(new int[]{7},993);
    }
    public List<Integer> addToArrayForm(int[] A, int K) {
        int carryBit = 0;
        int i = A.length - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (K > 0 || i >= 0 || carryBit != 0){
            int k = 0;
            if (K > 0 && i >= 0){
                k = A[i] + K % 10 + carryBit;
                carryBit = k / 10;
                K /= 10;
                i --;
            }else {
                if (i >= 0){
                    k = A[i--];
                }
                else if (K != 0){
                    k = K % 10;
                    K /= 10;
                }
                if (carryBit != 0){
                    k += carryBit;
                    carryBit = k / 10;
                }
            }
            list.add(k % 10);
        }
        Collections.reverse(list);
        return list;
    }
}
