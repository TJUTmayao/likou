package easy;

/**
 * @ClassName NO107
 * @Description 作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。 现给定一个具体的矩形页面面积，
 * 你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：
 *
 * 1. 你设计的矩形页面必须等于给定的目标面积。
 *
 * 2. 宽度 W 不应大于长度 L，换言之，要求 L >= W 。
 *
 * 3. 长度 L 和宽度 W 之间的差距应当尽可能小。你需要按顺序输出你设计的页面的长度 L 和宽度 W。
 * @Author 11432
 * @DATE 2019/8/5 10:50
 */
public class NO107 {
    public static void main(String[] args) {
        int[] ints = constructRectangle2(10000000);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        System.out.println(Math.sqrt(Integer.MAX_VALUE));
    }
    public static int[] constructRectangle(int area) {
        int x = 1;
        int y = area;
        int i = 0;
        while (x <= y){
            if (area % x == 0){
                y = area / x;
                i= x;
            }
            x++;
        }
        return new int[]{i,y};
    }

    public static int[] constructRectangle2(int area) {
        int start = 0;
        int end = area;
        int mid = 0;
        int i;
        while (start <= end){
            mid = start + ((end - start) >> 1);
            if (mid > 46340){
                end = mid - 1;
                continue;
            }
            i = mid * mid;
            if (i > area){
                end =mid - 1;
            }else {
                if (i == area){
                    return new int[]{mid ,mid};
                }
                start = mid + 1;
            }
        }
        while (area % mid != 0){
            mid --;
        }
        mid = mid > area /mid ? area / mid : mid;
        return new int[]{(area / mid),mid};
    }

}
