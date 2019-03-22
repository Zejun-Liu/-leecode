package com.jiuxian.A20190322_02;

import java.util.*;
import java.util.stream.Collectors;

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

        int[] nums1 = { 2, 2, 1 };
        int[] nums2 = { 4, 1, 2, 1, 2 };
        int[] a = solution.intersect2(nums1, nums2);
        System.out.println(Arrays.toString(a));
    }

    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> collect = Arrays.stream(nums2).boxed().filter(s -> {
            if (list1.contains(s)) {
                list1.remove(s);
                return true;
            }
            return false;
        }).collect(Collectors.toList());

        int[] res = new int[collect.size()];
        for (int i = 0; i < collect.size(); i++) {
            res[i] = collect.get(i);
        }
        return res;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (Integer num : nums1)
            if (map1.containsKey(num))
                map1.put(num, map1.get(num) + 1);
            else
                map1.put(num, 1);

        ArrayList<Integer> intersection = new ArrayList<>(16);
        for (Integer num : nums2) {
            if (map1.containsKey(num) && map1.get(num) > 0) {
                intersection.add(num);
                map1.put(num, map1.get(num) - 1);
            }
        }

        int[] ret = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++)
            ret[i] = intersection.get(i);
        return ret;
    }
}