package easy;

/**
 * @ClassName NO195
 * @Description 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
 *
 * 至少有一个空座位，且至少有一人坐在座位上。
 *
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 *
 * 返回他到离他最近的人的最大距离。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximize-distance-to-closest-person
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/4 16:29
 */
public class NO195 {
    public static void main(String[] args) {
        NO195 no195 = new NO195();
        System.out.println(no195.maxDistToClosest(new int[]{0,1,1,1,0,0,1,0,0}));
    }
    public int maxDistToClosest(int[] seats) {
        int max = 0;
        int maxIndex = seats.length - 1;
        int i,j;
        for (i = 0,j = 0; i < seats.length; i++) {
            if (seats[i] == 1){
                int k = i - j;
                if (j == 0 && seats[j] == 0){
                    k *= 2;
                }
                if (max < k){
                    max = k;
                }
                j = i;
            }
        }
        if (seats[maxIndex] == 0 && j < maxIndex){
            max = Math.max(max,(maxIndex - j) * 2);
        }
        return max / 2;
    }

//    int max = 0;
//        int st = -1;
//        int en = -1;
//        for (int i = 0,j = 0; i < seats.length; i++) {
//            if (seats[i] == 1 || i == seats.length - 1){
//                int k = i - j;
//                if (max < k){
//                    max = k;
//                    st = j;
//                    en = i;
//                }
//                if (max <= k + 1){
//                    if (i == seats.length - 1 && seats[i] == 0){
//                        st = j;
//                        en = i;
//                    }
//                }
//                j = i;
//            }
//        }
//        if (st == 0 && seats[st] == 0){
//            return max;
//        } else {
//            if (seats[en] == 0){
//                return max;
//            }
//        }
//        return max / 2;
}
