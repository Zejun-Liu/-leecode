package com.jiuxian.leetcode;

import java.util.*;

/**
 * @author: liuzejun
 * *
 * @email: 857591294@qq.com
 * *
 * @date: 2019-07-31 20:40:39
 * *
 * @comment: 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A20190731_01_Triangle_120 {

    private static class Solution {
        int minimumTotal1(List<List<Integer>> triangle) {
            if (triangle.isEmpty()) return 0;
            Integer[] f = triangle.get(triangle.size() - 1).toArray(new Integer[0]);
            for (int i = triangle.size() - 2; i >= 0; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    f[j] = triangle.get(i).get(j) + Math.min(f[j], f[j + 1]);
                    System.out.println(Arrays.toString(f));
                }
            }
            return f[0];
        }

        int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() == 0) return 0;
            int size = triangle.size();
            int[] f = new int[triangle.get(triangle.size() - 1).size()];
            for (int i = size - 1; i >= 0; i--) {
                List<Integer> list = triangle.get(i);
                for (int j = 0; j <= i; j++) {
                    f[j] = Math.min(f[j], f[j + 1]) + list.get(j);
                }
                System.out.println(Arrays.toString(f));
            }
            return f[0];
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(2));
        result.add(Arrays.asList(3, 4));
        result.add(Arrays.asList(6, 5, 7));
        result.add(Arrays.asList(4, 1, 8, 3));
        int total = new Solution().minimumTotal(result);
        System.out.println(total + " : " + (total == 11));


        result = new ArrayList<>();
        result.add(Collections.singletonList(-1));
        result.add(Arrays.asList(2, 3));
        result.add(Arrays.asList(1, -1, -3));
        total = new Solution().minimumTotal(result);
        System.out.println(total + " : " + (total == -1));
    }

}
