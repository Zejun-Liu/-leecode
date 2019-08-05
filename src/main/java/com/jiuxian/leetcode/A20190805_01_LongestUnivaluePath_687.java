package com.jiuxian.leetcode;

import com.jiuxian.leetcode.util.TreeNode;
import com.jiuxian.leetcode.util.TreeUtil;

/**
 * @author: liuzejun
 * *
 * @email: 857591294@qq.com
 * *
 * @date: 2019-08-05 21:32:43
 * *
 * @comment: 687.最长同值路径
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * <p>
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * 输出:
 * <p>
 * 2
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 4   5
 * / \   \
 * 4   4   5
 * 输出:
 * <p>
 * 2
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-univalue-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A20190805_01_LongestUnivaluePath_687 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    private static class Solution {
        int sum;

        public int longestUnivaluePath(TreeNode root) {
            sum = 0;
            sum(root);
            return sum;
        }

        private int sum(TreeNode node) {
            if (node == null) return 0;
            int left = sum(node.left);
            int right = sum(node.right);
            int _left = 0, _right = 0;
            if (node.left != null && node.left.val == node.val) {
                _left = left + 1;
            }
            if (node.right != null && node.right.val == node.val) {
                _right = right + 1;
            }
            sum = Math.max(sum, _left + _right);
            return Math.max(_left, _right);
        }


    }

    public static void main(String[] args) {
        TreeNode tree = TreeUtil.getTree("[5,4,5,1,1,5]");
        int sum = new Solution().longestUnivaluePath(tree);
        System.out.println(sum);
    }
}
