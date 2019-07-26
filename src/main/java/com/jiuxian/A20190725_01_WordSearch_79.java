package com.jiuxian;

/**
 * @author: liuzejun
 * *
 * @email: 857591294@qq.com
 * *
 * @date: 2019-07-25 20:53:04
 * *
 * @comment: 79. 单词搜索
 * <p>
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A20190725_01_WordSearch_79 {

    private static class Solution {
        private int[][] direction = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
        private boolean[][] marked;
        private int rowLength;
        private int colLength;
        private String word;
        private char[][] board;

        public boolean exist(char[][] board, String word) {
            this.word = word;
            this.board = board;
            this.rowLength = board.length;
            if (rowLength == 0) return false;
            this.colLength = board[0].length;
            this.marked = new boolean[rowLength][colLength];

            for (int i = 0; i < rowLength; i++) {
                for (int j = 0; j < colLength; j++) {
                    if (dfs(i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(int i, int j, int start) {
            if (start == word.length() - 1) {
                return board[i][j] == word.charAt(start);
            }
            if (board[i][j] == word.charAt(start)) {
                marked[i][j] = true;
                for (int direct = 0; direct < 4; direct++) {
                    int x = i + direction[direct][0];
                    int y = j + direction[direct][1];
                    if (!inArea(x, y) || marked[x][y]) continue;
                    if (dfs(x, y, start + 1)) {
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
        private class TrieNode {
            private TrieNode[] nodes = new TrieNode[26];

            private int getKey(char ch) {
                return ch - 'A';
            }

            public boolean containsKey(char ch) {
                return nodes[getKey(ch)] != null;
            }

            public TrieNode getNode(char ch) {
                return nodes[getKey(ch)];
            }

            public void put(char ch, TrieNode node) {
                nodes[getKey(ch)] = node;
            }
        }

        private TrieNode insert(TrieNode root, char ch) {
            if (!root.containsKey(ch)) {
                root.put(ch, new TrieNode());
            }
            return root.getNode(ch);
        }

        private boolean search(TrieNode root, String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (!node.containsKey(ch)) {
                    return false;
                }
                node = node.getNode(ch);
            }
            return true;
        }

        public boolean exist(char[][] board, String word) {
            TrieNode root = new TrieNode();
            for (char[] chars : board) {
                for (char ch : chars) {
                    insert(root, ch);
                }
            }
            return search(root, word);
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' } };
        boolean exist = new Solution2().exist(board, "ABCCED");
        System.out.println(exist);
    }
}
