package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @ClassName NO206
 * @Description 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
 *
 * 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 *
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 *
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fair-candy-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/9 15:12
 */
public class NO206 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int length = Math.min(A.length,B.length);
        int sum = 0;
        int i;
        HashSet<Integer> set = new HashSet<>();
        for (i = 0; i < length; i++) {
            sum += A[i] - B[i];
            set.add(B[i]);
        }
        while (i < B.length){
            set.add(B[i]);
            sum -= B[i++];
        }
        while (i < A.length){
            sum += A[i++];
        }
        sum = sum / 2;
        for (int k = 0; k < A.length; k++) {
            if (set.contains(A[k] - sum)){
                return new int[]{A[k],A[k] - sum};
            }
        }
        return new int[]{};
    }

}
