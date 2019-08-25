package easy;

import com.sun.jmx.snmp.SnmpDataTypeEnums;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ClassName NO160
 * @Description 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 *
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/22 14:44
 */
public class NO160 {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println();
    }
}
//class KthLargest {
//    int[] maxK;
//    List<Integer> list = new ArrayList<>();
//    public KthLargest(int k, int[] nums) {
//        this.maxK = new int[k];
//        for (int i = 0; i < k; i++) {
//            maxK[i] = Integer.MIN_VALUE;
//        }
//        for (int num : nums) {
//            add(num);
//        }
//    }
//
//    public int add(int val) {
//        int i;
//        list.add(val);
//        for (i = -1; i < maxK.length - 1; i++) {
//            if(maxK[i + 1] > val){
//                break;
//            }
//            if (i < maxK.length - 2){
//                maxK[i + 1] = maxK[i + 2];
//            }
//        }
//        if (i >= 0){
//            maxK[i] = val;
//        }
//        return maxK[0];
//    }
//}
//class KthLargest {
//    int[] heap;
//    int length = 0;
//
//    public KthLargest(int k, int[] nums) {
//        this.heap = new int[k];
////        PriorityQueue
//        for (int i = 0; i < nums.length; i++) {
//            add(nums[i]);
//        }
//    }
//
//    public int add(int val) {
//        if (length < heap.length){
//            putInHeapNotFull(val);
//            length++;
//        }else {
//            putInHeapFull(val);
//        }
//        return heap[0];
//    }
//
//    public void putInHeapFull(int val){
//        // 大于 小顶堆 堆顶
//        if (val > heap[0]){
//            int i = 0;
//            int x = 1;
//            heap[i] = val;
//            while (x < heap.length){
//                if (x + 1 < heap.length && heap[x] > heap[x + 1]){
//                    x ++;
//                }
//                if (heap[x] > heap[i]){
//                    break;
//                }
//                heap[i] = heap[x];
//                heap[x] = val;
//                i = x;
//                x = i * 2 + 1;
//            }
//        }
//    }
//
//    public void putInHeapNotFull(int val){
//        int i = length;
//        heap[i] = val;
//        int parent = (i - 1) >> 1;
//        while (i > 0 && heap[i] < heap[parent]){
//            heap[i] = heap[parent];
//            heap[parent] = val;
//            i = parent;
//            parent = (i - 1) >> 1;
//        }
//    }
//
//}
class KthLargest {
    /** java 提供的小顶堆 */
    PriorityQueue<Integer> heap ;
    int k;
    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (heap.size() < k){
            heap.add(val);
        }
        else if (heap.peek() < val){
            heap.add(val);
            heap.poll();
        }
        return heap.peek();
    }
}