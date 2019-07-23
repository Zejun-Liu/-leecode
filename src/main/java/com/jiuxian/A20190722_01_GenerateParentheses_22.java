package com.jiuxian;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liuzejun
 * *
 * @email: 857591294@qq.com
 * *
 * @date: 2019-07-22 20:21:45
 * *
 * @comment: 22. 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A20190722_01_GenerateParentheses_22 {

    private static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            generate(list, 0, 0, n, "");
            return list;
        }

        private void generate(List<String> list, int left, int right, int n, String result) {
            if (left == n && right == n) {
                list.add(result);
                return;
            }

            if (left < n) {
                generate(list, left + 1, right, n, result + "(");
            }
            if (left > right && right < n) {
                generate(list, left, right + 1, n, result + ")");
            }
        }
    }

    public static void main(String[] args) {
        List<String> strings = new Solution().generateParenthesis(3);
        System.out.println(strings);
    }

}
