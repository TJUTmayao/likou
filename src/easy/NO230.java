package easy;

/**
 * @ClassName NO230
 * @Description 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * @Author 11432
 * @DATE 2019/9/23 16:05
 */
public class NO230 {
    public static void main(String[] args) {
        System.out.println(new NO230().sortedSquares2(new int[]{-4,-1,0,3,10}));
    }
    public int[] sortedSquares(int[] A) {
        int i,j,k;
        for (i = 0; i < A.length && A[i] < 0; i++) { }
        int[] ints = new int[A.length];
        int count = 0;
        for (j = i - 1,k = i; j >= 0 && k < A.length;) {
            if(-A[j] <= A[k]){
                ints[count++] = A[j] * A[j];
                j--;
            }else {
                ints[count++] = A[k] * A[k];
                k++;
            }
        }
        if (k != A.length){
            while (k < A.length){
                ints[count++] = A[k] * A[k];
                k++;
            }
        }else{
            while (j >= 0){
                ints[count++] = A[j] * A[j];
                j--;
            }
        }
        return ints;
    }

    public int[] sortedSquares2(int[] A) {
        int L = 0,R = A.length - 1;
        int[] ints = new int[A.length];
        int count = R;
        while (L <= R){
            if (A[L] < 0 && -A[L] > A[R]){
                ints[count--] = A[L] * A[L];
                L++;
            }else {
                ints[count--] = A[R] * A[R];
                R--;
            }
        }
        return ints;
    }
}
