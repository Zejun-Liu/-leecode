package com.jiuxian.leetcode;

import java.util.*;

/**
 * @author: liuzejun
 * *
 * @email: 857591294@qq.com
 * *
 * @date: 2019-07-25 21:14:50
 * *
 * @comment: 212. 单词搜索 II
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * <p>
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 * <p>
 * 提示:
 * <p>
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A20190725_02_WordSearchII_212 {

    private static class Solution {
        private int[][] direction = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
        private boolean[][] marked;
        private char[][] board;
        private int rowLength;
        private int colLength;

        public List<String> findWords(char[][] board, String[] words) {
            if (board == null || board.length == 0 || words == null || words.length == 0) return Collections.emptyList();
            this.board = board;
            this.rowLength = board.length;
            this.colLength = board[0].length;
            List<String> result = new ArrayList<>();
            for (String word : words) {
                this.marked = new boolean[rowLength][colLength];
                for (int i = 0; i < rowLength; i++) {
                    for (int j = 0; j < colLength; j++) {
                        if (dfs(word, i, j, 0)) {
                            result.add(word);
                            i = rowLength;
                            break;
                        }
                    }
                }
            }

            return result;
        }

        private boolean dfs(String word, int i, int j, int start) {
            if (start == word.length() - 1) {
                return board[i][j] == word.charAt(start);
            }
            if (board[i][j] == word.charAt(start)) {
                marked[i][j] = true;
                for (int direct = 0; direct < 4; direct++) {
                    int x = i + direction[direct][0];
                    int y = j + direction[direct][1];
                    if (!inArea(x, y) || marked[x][y]) continue;
                    if (dfs(word, x, y, start + 1)) {
                        return true;
                    }
                }
                marked[i][j] = false;
            }
            return false;
        }


        private boolean inArea(int x, int y) {
            return x >= 0 && y >= 0 && x < rowLength && y < colLength;
        }
    }

    private static class Solution2 {

        public List<String> findWords(char[][] board, String[] words) {
            if (board == null || board.length == 0 || words == null || words.length == 0) return Collections.emptyList();

            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }

            int rowLength = board.length;
            int colLength = board[0].length;

            boolean[][] marked = new boolean[rowLength][colLength];
            List<String> result = new ArrayList<>();

            for (int i = 0; i < rowLength; i++) {
                for (int j = 0; j < colLength; j++) {
                    search(board, marked, i, j, rowLength, colLength, trie.root, result);
                }
            }
            return new ArrayList<>(result);
        }

        private void search(char[][] board, boolean[][] marked, int row, int col, int rowLength, int colLength, TrieNode node, List<String> result) {
            if (row < 0 || col < 0 || row >= rowLength || col >= colLength || marked[row][col]) return;

            if (!node.containKey(board[row][col])) return;

            node = node.get(board[row][col]);
            if (node.getWord() != null) {
                result.add(node.getWord());
            }
            marked[row][col] = true;
            search(board, marked, row - 1, col, rowLength, colLength, node, result);
            search(board, marked, row + 1, col, rowLength, colLength, node, result);
            search(board, marked, row, col - 1, rowLength, colLength, node, result);
            search(board, marked, row, col + 1, rowLength, colLength, node, result);
            marked[row][col] = false;
        }

        private class Trie {
            TrieNode root = new TrieNode();

            void insert(String word) {
                TrieNode node = this.root;
                for (char ch : word.toCharArray()) {
                    if (!node.containKey(ch)) {
                        node.put(ch, new TrieNode());
                    }
                    node = node.get(ch);
                }
                node.setWord(word);
            }
        }

        private class TrieNode {
            private TrieNode[] trees = new TrieNode[26];

            private String word;

            boolean containKey(char ch) {
                return trees[ch - 'a'] != null;
            }

            TrieNode get(char ch) {
                return trees[ch - 'a'];
            }

            void put(char ch, TrieNode node) {
                trees[ch - 'a'] = node;
            }

            void setWord(String word) {
                this.word = word;
            }

            String getWord() {
                return word;
            }
        }
    }


    public static void main(String[] args) {
        String[] words = { "oath", "pea", "eat", "rain" };
        char[][] board = {
                { 'o', 'a', 'a', 'n' },
                { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' } };
        List<String> result = new Solution2().findWords(board, words);
        System.out.println(result);
    }
}
