package com.jiuxian.A20190320_01;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * @see <a href="https://leetcode-cn.com/problems/implement-strstr/"></a>
 */
class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.strStr("mississippi", "issipi");
//        int i = solution.strStr(""mississippi"
//"issi"", "bba");
        System.out.println(i);
    }

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) return 0;
        if (needle.length() > haystack.length()) return -1;
        if (haystack.equals(needle)) return 0;

        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();

        int nIndex = 0;
        int hReturnIndex = 0;
        int firstIndex = -1;
        for (int hIndex = 0; hIndex < haystacks.length; hIndex++) {
            if (nIndex == needles.length) return hIndex - needles.length;

            if (haystacks[hIndex] == needles[nIndex]) {
                if (firstIndex == -1) {
                    firstIndex = hIndex;
                }
                nIndex++;
            } else {
                if (firstIndex >= 0) {
                    hIndex = hReturnIndex ++;
                }
                firstIndex = -1;
                nIndex = 0;
            }
        }
        if (nIndex != needles.length) return -1;
        return firstIndex;
    }


}