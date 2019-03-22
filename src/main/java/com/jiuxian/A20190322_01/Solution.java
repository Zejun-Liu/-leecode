package com.jiuxian.A20190322_01;

import java.util.HashSet;
import java.util.Set;

/**
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * @see <a href="https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/25/"></a>
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[] nums = { 2, 2, 1 };
        int[] nums = { 4, 1, 2, 1, 2 };
//        int[] nums = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        int a = solution.singleNumber2(nums);
        System.out.println(a);
    }

    /**
     * 　请注意：上面 putVal 方法中，调用的 resize() 、 putTreeVal() 等方法本身也是O(n2)的时间复杂度。不符合题目要求的线性时间复杂度。
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                set.remove(nums[i]);
            }
        }
        return set.iterator().next();
    }


    /**
     * 思路：根据异或运算的特点，相同的数字经过异或运算后结果为0，除单独出现一次的数字外，
     * 其他数字都是出现两次的，那么这些数字经过异或运算后结果一定是0。而任何数字与0进行异或运算都是该数字本身。
     * 所以对数组所有元素进行异或运算，运算结果就是题目的答案。
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            single = single ^ nums[i];
        }
        return single;
    }
}