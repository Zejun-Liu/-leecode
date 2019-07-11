package com.jiuxian;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: liuzejun
 * *
 * @email: 857591294@qq.com
 * *
 * @date: 2019-07-11 21:12:05
 * *
 * @comment: 20. 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A20190711_03_ValidParentheses {

    public boolean isValid(String s) {

        Map<String, String> map = new HashMap<String, String>(3) {{
            put("]", "[");
            put(")", "(");
            put("}", "{");
        }};
        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            String str = String.valueOf(aChar);
            if (!map.containsKey(str)) {
                stack.push(str);
            } else if (stack.isEmpty() || !stack.pop().equals(map.get(str))) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean valid = new A20190711_03_ValidParentheses().isValid("[]");
        System.out.println(valid);
    }
}
