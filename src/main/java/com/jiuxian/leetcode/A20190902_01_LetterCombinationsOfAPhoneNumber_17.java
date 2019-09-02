package com.jiuxian.leetcode;

import java.util.*;

/**
 * @author: zejun.liu
 * *
 * @date: 2019/9/2 17:16
 * *
 * @description: 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A20190902_01_LetterCombinationsOfAPhoneNumber_17 {

    private static class Solution {
        private static Map<Integer, List<String>> map = new HashMap<Integer, List<String>>() {{
            put(2, Arrays.asList("a", "b", "c"));
            put(3, Arrays.asList("d", "e", "f"));
            put(4, Arrays.asList("g", "h", "i"));
            put(5, Arrays.asList("j", "k", "l"));
            put(6, Arrays.asList("m", "n", "o"));
            put(7, Arrays.asList("p", "q", "r", "s"));
            put(8, Arrays.asList("t", "u", "v"));
            put(9, Arrays.asList("w", "x", "y", "z"));
        }};
        private List<String> out = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            List<Integer> figures = new ArrayList<>();
            for (char c : digits.toCharArray()) {
                figures.add(c - '0');
            }
            if (digits.length() != 0) {
                backtrack("", figures, 0);
            }
            return out;
        }

        private void backtrack(String combination, List<Integer> figures, int index) {
            if (index == figures.size()) {
                out.add(combination);
                return;
            }
            Integer digit = figures.get(index);
            List<String> letters = map.get(digit);
            for (String letter : letters) {
                backtrack(combination + letter, figures, index + 1);
            }
        }

    }


    public static void main(String[] args) {
        String dis = "23";
        List<String> strings = new Solution().letterCombinations(dis);
        System.out.println(strings);
    }


}
