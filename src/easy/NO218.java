package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName NO218
 * @Description 写一个 RecentCounter 类来计算最近的请求。
 *
 * 它只有一个方法：ping(int t)，其中 t 代表以毫秒为单位的某个时间。
 *
 * 返回从 3000 毫秒前到现在的 ping 数。
 *
 * 任何处于 [t - 3000, t] 时间范围之内的 ping 都将会被计算在内，包括当前（指 t 时刻）的 ping。
 *
 * 保证每次对 ping 的调用都使用比之前更大的 t 值
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-recent-calls
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/14 17:06
 */
public class NO218 {
    public static void main(String[] args) {

    }
    class RecentCounter {
        Queue<Integer> queue;
        private static final int BEFOR = 3000;

        public RecentCounter() {
            this.queue = new LinkedList<>();
        }

        public int ping(int t) {
            int i = t - BEFOR;
            queue.offer(t);
            while (!queue.isEmpty() && queue.peek() < i){
                queue.poll();
            }
            return queue.size();
        }
    }
}
