package com.jiuxian;

import java.util.*;

/**
 * @author: liuzejun
 * *
 * @email: 857591294@qq.com
 * *
 * @date: 2019-07-22 21:46:02
 * *
 * @comment: 51. N皇后
 * <p>
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A20190722_02_NQueens_51 {
    //TODO 没有搞明白
    private static class Solution {
        List<List<String>> solveNQueens(int n) {
            List<List<String>> result = new ArrayList<>();
            Set<Integer> col = new HashSet<>();
            Set<Integer> pie = new HashSet<>();
            Set<Integer> na = new HashSet<>();
            solve(result, new ArrayList<>(), col, pie, na, n, 0);
            return result;
        }

        private void solve(List<List<String>> result, List<String> list, Set<Integer> cols, Set<Integer> pie, Set<Integer> na, int n, int row) {
            if (list.size() == n) {
                result.add(list);
                return;
            }
            for (int col = 0; col < n; col++) {
                if (cols.contains(col) || pie.contains(row + col) || na.contains(row - col)) {
                    continue;
                }

                String[] rows = new String[n];
                Arrays.fill(rows, ".");
                rows[col] = "Q";
                list.addAll(Arrays.asList(rows));

                cols.add(col);
                pie.add(row + col);
                na.add(row - col);

                solve(result, list, cols, pie, na, n, row + 1);

                cols.remove(col);
                pie.remove(row + col);
                na.remove(row - col);
            }
        }

    }

    public static void main(String[] args) {
        List<List<String>> lists = new Solution().solveNQueens(4);
        lists.forEach(System.out::println);
    }
}
