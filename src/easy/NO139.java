package easy;

/**
 * @ClassName NO139
 * @Description 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * @Author 11432
 * @DATE 2019/8/13 16:11
 */
public class NO139 {
    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{-710,-107,-851,657,-14,-859,278,-182,-749,718,-640,127,-930,
                -462,694,969,143,309,904,-651,160,451,-159,-316,844,-60,611,-169,-73,721,-902,338,-20,-890,-819,-644,107,404,
                150,-219,459,-324,-385,-118,-307,993,202,-147,62,-94,-976,-329,689,870,532,-686,371,-850,-186,87,878,989,-822,
                -350,-948,-412,161,-88,-509,836,-207,-60,771,516,-287,-366,-512,509,904,-459,683,-563,-766,-837,-333,93,893,303
                ,908,532,-206,990,280,826,-13,115,-732,525,-939,-787}));
    }
    public static int maximumProduct(int[] nums) {
        int[] maxInts = new int[]{-1001,-1001,-1001};
        int[] minInts = new int[]{1001,1001};
        int x = 0,y = 0;
        int maxSize = 3;
        int minSize = 2;
        for (int i = 0; i < nums.length; i++,x = 0,y = 0) {
            // 统计前三大
            while (x < maxSize && maxInts[x] < nums[i]){
                if (x > 0){
                    maxInts[x - 1] = maxInts[x];
                }
                x++;
            }
            if (x > 0){
                maxInts[x - 1] = nums[i];
            }
            // 统计前二小
            while (y < minSize && minInts[y] > nums[i]){
                if (y > 0){
                    minInts[y - 1] = minInts[y];
                }
                y++;
            }
            if (y > 0){
                minInts[y - 1] = nums[i];
            }
        }
        // 需要扩展
        int i = maxInts[0] * maxInts[1];
        if (minInts[0] < 0){
            int k = minInts[0] * minInts[1];
            if (i < k){
                return maxInts[2] * k;
            }
        }
        return i * maxInts[2];
    }

    public static int maximumProduct2(int[] nums) {
        int max1 = -1001,max2 = -1001,max3 = -1001;
        int min1 = 1001,min2 = 1001;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1){
                max1 = nums[i];
                if (nums[i] > max2){
                    max1 = max2;
                    max2 = nums[i];
                    if (nums[i] > max3){
                        max2 = max3;
                        max3 = nums[i];
                    }
                }
            }
            if (min1 > nums[i]){
                min1 = nums[i];
                if (min2 > nums[i]){
                    min1 = min2;
                    min2 = nums[i];
                }
            }
        }
        int i = max1 * max2;
        if (min1 < 0){
            if (min1 * min2 > i){
                i = min1 * min2;
            }
        }
        return i * max3;
    }
}
