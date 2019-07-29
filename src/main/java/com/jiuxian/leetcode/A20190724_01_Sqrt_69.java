package com.jiuxian.leetcode;

/**
 * @author: liuzejun
 * *
 * @email: 857591294@qq.com
 * *
 * @date: 2019-07-24 20:48:16
 * *
 * @comment: 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A20190724_01_Sqrt_69 {

    private static class Solution {

        public double mySqrt(int x) {
            double left = 0;
            double right = x;
            while (Math.abs(left - right) > 1e-1) {
                double mid = (left + right) / 2;
                if (mid * mid == x) {
                    return mid;
                } else if (mid * mid > x) {
                    right = mid;
                } else {
                    left = mid;
                }
                System.out.println(mid);
            }
            return 0;
        }

        public int mySqrt2(int x) {
            if (x == 1 || x == 0) return x;
            long left = 0, right = x;
            while (left < right) {
                long mid = (left + right + 1) >> 1;
                if (mid * mid > x) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            return (int) left;
        }

        public int mySqrt3(int a) {
            long x = a;
            while (x * x > a) {
                x = (x + a / x) / 2;
            }
            return (int) x;
        }
    }

    public static void main(String[] args) {
        double i = new Solution().mySqrt3(8);
        System.out.println(i);
    }
}
