package com.jiuxian.leetcode;

/**
 * @author: liuzejun
 * *
 * @email: 857591294@qq.com
 * *
 * @date: 2019-07-18 21:06:27
 * *
 * @comment: 50. Pow(x, n)
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A20190718_03_Pow_50 {

    public double myPow(double x, int n) {
        if (n == 0) return 1;

        if (n < 0) {
            return 1 / myPow(x, -n);
        }
        if (n % 2 == 1) {
            return x * myPow(x, n - 1);
        }
        return myPow(x * x, n / 2);
    }

    public double fastPow(double x, int n) {
        if (n == 0) return 1.0;
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow3(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fastPow(x, n);
    }


    public double myPow4(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double ans = 1;
        double current_product = x;
        for (int i = n; i > 0; i /= 2) {
            if (i % 2 == 1) {
                ans *= current_product;
            }
            current_product *= current_product;
        }
        return ans;
    }


    public double myPow2(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double pow = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                pow *= x;
            }
            x *= x;
            n >>= 1;
        }
        return pow;
    }


    public static void main(String[] args) {
        double v = new A20190718_03_Pow_50().myPow3(2.00000, -2147483648);
        System.out.println(v);
    }
}
