package easy;

/**
 * @ClassName NO215
 * @Description 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/13 17:29
 */
public class NO215 {
    public static void main(String[] args) {
        int[] ints = sortArrayByParityII(new int[]{3,1,4,2});
        System.out.println();
    }
    public static int[] sortArrayByParityII(int[] A) {
        int k;
        for (int i = 1,j = -2; i < A.length; i += 2) {
            if (A[i] % 2 == 0){
                do {
                    j += 2;
                }while (A[j] % 2 == 0);
                k = A[j];
                A[j] = A[i];
                A[i] = k;
            }
        }
        return A;
    }
}
