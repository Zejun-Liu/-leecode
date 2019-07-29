package com.jiuxian.leetcode;

import java.util.*;

/**
 * @author: liuzejun
 * *
 * @email: 857591294@qq.com
 * *
 * @date: 2019-07-17 20:14:14
 * *
 * @comment: 18. 四数之和
 * <p>
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A20190717_01_4Sum_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) return Collections.emptyList();

        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            for (int j = i + 1; j < length - 2; j++) {
                int L = j + 1, R = length - 1;
                while (L < R) {
                    int last = nums[i] + nums[j] + nums[L] + nums[R] - target;
                    if (last == 0) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[L], nums[R]);
                        list.sort(Comparator.comparing(s -> s));
                        result.add(list);
                        L++;
                        R--;
                    } else if (last > 0) {
                        R--;
                    } else {
                        L++;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    public List<List<Integer>> fourSum1(int[] nums, int target) {
        if (nums.length < 4) return Collections.emptyList();

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;

        for (int i = 0; i < length - 3; i++) {
            //第一个数去重
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            for (int j = i + 1; j < length - 2; j++) {
                //第二个数去重
                if (j - i > 1 && nums[j - 1] == nums[j]) continue;
                int L = j + 1, R = length - 1;
                while (L < R) {
                    int last = nums[i] + nums[j] + nums[L] + nums[R] - target;
                    if (last == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        //第三个数和第四个数去重
                        while (L < R && nums[L + 1] == nums[L]) L++;
                        while (L < R && nums[R - 1] == nums[R]) R--;
                        L++;
                        R--;
                    } else if (last > 0) {
                        R--;
                    } else {
                        L++;
                    }
                }
            }
        }
        return result;
    }
}
