package com.jiuxian;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: liuzejun
 * *
 * @email: 857591294@qq.com
 * *
 * @date: 2019-07-11 22:31:51
 * *
 * @comment: 703. 数据流中的第K大元素
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * <p>
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 * <p>
 * 示例:
 * <p>
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * 说明:
 * 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A20190711_05_KthLargestElementInAStream_703 {

    private Queue<Integer> priorityQueue;
    private int k;

    public A20190711_05_KthLargestElementInAStream_703(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>(k);
        this.k = k;
        this.init(nums);
    }

    private void init(int[] nums) {
        for (int num : nums) {
            add(num);
        }
    }

    public Integer add(int val) {
        priorityQueue.offer(val);
        if (priorityQueue.size() > k) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }


    public Queue<Integer> getPriorityQueue() {
        return priorityQueue;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 8, 2 };
        A20190711_05_KthLargestElementInAStream_703 stream = new A20190711_05_KthLargestElementInAStream_703(3, nums);
        System.out.println(stream.getPriorityQueue());
        System.out.println(stream.add(3));
        System.out.println(stream.add(5));
        System.out.println(stream.add(10));
        System.out.println(stream.add(9));
        System.out.println(stream.add(4));
    }
}
