package com.jiuxian.leetcode;

/**
 * @author: liuzejun
 * *
 * @email: 857591294@qq.com
 * *
 * @date: 2019-07-30 21:34:34
 * *
 * @comment: 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A20190730_02_ClimbingStairs_70 {

    private static class Solution {
        int climbStairs(int n) {
            if (n <= 1) return n;
            int[] f = new int[n + 1];
            f[1] = f[0] = 1;
            for (int i = 2; i <= n; i++) {
                f[i] = f[i - 2] + f[i - 1];
            }
            return f[n];
        }

        int climbStairs2(int n) {
            if (n <= 1) return n;
            int first = 1;
            int second = 2;
            for (int i = 3; i <= n; i++) {
                int third = first + second;
                first = second;
                second = third;
            }
            return second;
        }
    }


    public static void main(String[] args) {
        int i = new Solution().climbStairs2(2);
        System.out.println(i + " " + (i == 2));

        i = new Solution().climbStairs2(3);
        System.out.println(i + " " + (i == 3));

        i = new Solution().climbStairs2(4);
        System.out.println(i + " " + (i == 5));
    }
}
