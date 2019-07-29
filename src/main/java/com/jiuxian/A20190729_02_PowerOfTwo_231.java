package com.jiuxian;

/**
 * @author: liuzejun
 * *
 * @email: 857591294@qq.com
 * *
 * @date: 2019-07-29 21:16:08
 * *
 * @comment: 231. 2的幂
 * <p>
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 * <p>
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 * <p>
 * 输入: 218
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A20190729_02_PowerOfTwo_231 {

    private static class Solution {

        public boolean isPowerOfTwo(int n) {
            return n > 0 && Integer.bitCount(n) == 1;
        }

        public boolean isPowerOfTwo2(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }

        public boolean isPowerOfTwo3(int n) {
            if (n <= 0) return false;
            while (n > 1) {
                if ((n & 1) == 0) {
                    n /= 2;
                } else {
                    return false;
                }
            }
            return true;
        }
    }


    public static void main(String[] args) {
        boolean powerOfTwo = new Solution().isPowerOfTwo3(1);
        System.out.println(powerOfTwo);

        powerOfTwo = new Solution().isPowerOfTwo3(16);
        System.out.println(powerOfTwo);

        powerOfTwo = new Solution().isPowerOfTwo3(218);
        System.out.println(powerOfTwo);
    }

}
