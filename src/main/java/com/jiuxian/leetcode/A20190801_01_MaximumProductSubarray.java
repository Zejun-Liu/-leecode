package com.jiuxian.leetcode;

/**
 * @author: liuzejun
 * *
 * @email: 857591294@qq.com
 * *
 * @date: 2019-08-01 20:16:04
 * *
 * @comment: 152. 乘积最大子序列
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A20190801_01_MaximumProductSubarray {

    private static class Solution {

        int maxProduct(int[] nums) {
            int max = Integer.MIN_VALUE, iMax = 1, iMin = 1;
            for (int num : nums) {
                if (num < 0) {
                    int tmp = iMax;
                    iMax = iMin;
                    iMin = tmp;
                }
                iMax = Math.max(iMax * num, num);
                iMin = Math.min(iMin * num, num);
                max = Math.max(max, iMax);
            }
            return max;
        }
    }


    public static void main(String[] args) {
        int[] nums = { 2, 3, -2, 4 };
        int i = new Solution().maxProduct(nums);
        System.out.println(i);

        int[] nums2 = { -2, 0, -1 };
        int i1 = new Solution().maxProduct(nums2);
        System.out.println(i1);

        int[] nums3 = { -2, 3, -4 };
        int i3 = new Solution().maxProduct(nums3);
        System.out.println(i3);

    }
}
