package com.jiuxian.A20190322_03;

import java.util.Arrays;

/**
 * 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * @see <a href="https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/26/"></a>
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = { 8, 9, 9, 9 };
//        int[] nums = { 4,3,2,1 };
        int[] a = solution.plusOne(nums);
        System.out.println(Arrays.toString(a));
    }


    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            //非9加1
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            //逢9置0
            digits[i] = 0;
        }
        //全部为9，则需要数组扩充1位
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}