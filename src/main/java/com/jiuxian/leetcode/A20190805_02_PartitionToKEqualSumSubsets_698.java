package com.jiuxian.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: liuzejun
 * *
 * @email: 857591294@qq.com
 * *
 * @date: 2019-08-05 22:05:23
 * *
 * @comment: 698. 划分为k个相等的子集
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 *  
 * <p>
 * 注意:
 * <p>
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A20190805_02_PartitionToKEqualSumSubsets_698 {

    private static class Solution {
        boolean canPartitionKSubsets(int[] nums, int k) {
            if (k == 0) return true;

            int sum = 0;
            int max = 0;
            for (int num : nums) {
                sum += num;
                if (num > max) {
                    max = num;
                }
            }
            //总和不能被子集数整除，肯定不存在
            if (sum % k != 0) return false;
            //子集平均和小于最大值，肯定不存在
            if (sum / k < max) return false;

            Arrays.sort(nums);
            List<Integer> list = new ArrayList<>();
            for (int i = nums.length - 1; i >= 0; i--) {
                list.add(nums[i]);
            }
            return check(list, 0, k, sum / k);
        }

        private boolean check(List<Integer> list, int sum, int k, int target) {
            if (k == 0) return true;

            for (int i = 0; i < list.size(); i++) {
                int curr = sum + list.get(i);
                Integer remove = list.remove(i);
                if ((curr == target && check(list, 0, k - 1, target))
                        || (curr < target && check(list, curr, k, target))) {
                    return true;
                }
                list.add(i, remove);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 3, 5, 2, 1 };
        int k = 4;
        boolean b = new Solution().canPartitionKSubsets(nums, k);
        System.out.println(b);
    }
}
