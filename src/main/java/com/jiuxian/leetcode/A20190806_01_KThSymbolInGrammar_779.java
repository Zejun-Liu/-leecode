package com.jiuxian.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liuzejun
 * *
 * @email: 857591294@qq.com
 * *
 * @date: 2019-08-06 21:33:07
 * *
 * @comment: 779. 第K个语法符号
 * <p>
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * <p>
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 * <p>
 * 例子:
 * <p>
 * 输入: N = 1, K = 1
 * 输出: 0
 * <p>
 * 输入: N = 2, K = 1
 * 输出: 0
 * <p>
 * 输入: N = 2, K = 2
 * 输出: 1
 * <p>
 * 输入: N = 4, K = 5
 * 输出: 1
 * <p>
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 第三行: 0110
 * 第四行: 01101001
 * <p>
 * 注意：
 * <p>
 * N 的范围 [1, 30].
 * K 的范围 [1, 2^(N-1)].
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-th-symbol-in-grammar
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A20190806_01_KThSymbolInGrammar_779 {
    private static class Solution {
        int kthGrammar(int N, int K) {
            List<String> list = new ArrayList<>();
            result(list, new StringBuffer("0"), N);
            return Integer.parseInt(list.get(0).substring(K - 1, K));
        }

        private void result(List<String> list, StringBuffer buffer, int n) {
            if (n == 0) return;
            StringBuffer result = new StringBuffer();
            buffer.chars().forEach(s -> {
                if (s - 48 == 1) {
                    result.append("10");
                } else {
                    result.append("01");
                }
            });
            list.clear();
            list.add(result.toString());
            result(list, result, n - 1);
        }

        /**
         * //附图
         * //序号
         * //              1
         * //          /        \
         * //      1                2
         * //    /   \            /    \
         * //  1       2        3       4
         * // / \     /  \     /  \    / \
         * //1   2   3    4   5    6  7   8
         * <p>
         * //01排列
         * //              0
         * //          /        \
         * //      0                1
         * //    /   \            /    \
         * //  0       1        1       0
         * // / \     /  \     /  \    / \
         * //0   1   1    0   1    0  0   1
         * @param N
         * @param K
         * @return
         */
        public int kthGrammar2(int N, int K) {
            if (N == 1 && K == 1)
                return 0;
            int a = kthGrammar(N - 1, (K + 1) / 2);  //求父结点的值；(K+1)/2为父结点的序号
            int b = -(a - 1);   //若a=0则b=1,若a=1则b=0
            if (K % 2 == 1)
                return a;   //K为奇数则其值与父结点相同
            else
                return b;
        }

        // 通过归纳得出：计算K-1的二进制位数，为奇数则结果为1，偶数则结果为0
        public int kthGrammar3(int N, int K) {
            return Integer.bitCount(K - 1) % 2;
        }

    }

    public static void main(String[] args) {
        int N = 1;
        int K = 1;
        int i = new Solution().kthGrammar(N, K);
        System.out.println(i);

        N = 2;
        K = 1;
        i = new Solution().kthGrammar(N, K);
        System.out.println(i);

        N = 2;
        K = 2;
        i = new Solution().kthGrammar(N, K);
        System.out.println(i);

        N = 4;
        K = 5;
        i = new Solution().kthGrammar(N, K);
        System.out.println(i);
    }
}
