package com.jiuxian.leetcode;

import com.jiuxian.leetcode.util.TreeNode;
import com.jiuxian.leetcode.util.TreeUtil;

import java.util.*;

/**
 * @author: liuzejun
 * *
 * @email: 857591294@qq.com
 * *
 * @date: 2019-07-20 22:51:31
 * *
 * @comment: 102. 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A20190720_02_BinaryTreeLevelOrderTraversal_102 {

    private static class Solution {
        //BFS 广度优先
        List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.addLast(root);
            while (!stack.isEmpty()) {
                int len = stack.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < len; i++) {
                    TreeNode node = stack.removeFirst();
                    list.add(node.val);
                    if (node.left != null) {
                        stack.addLast(node.left);
                    }
                    if (node.right != null) {
                        stack.addLast(node.right);
                    }
                }
                result.add(list);
            }
            return result;
        }

        //DFS 深度优先
        List<List<Integer>> levelOrder2(TreeNode root) {
            if (root == null) return Collections.emptyList();
            List<List<Integer>> result = new ArrayList<>();
            dfs(result, root, 0);
            return result;
        }

        private void dfs(List<List<Integer>> result,
                         TreeNode node, Integer level) {
            if (node == null) return;
            if (result.size() < level + 1) {
                result.add(new ArrayList<>());
            }

            result.get(level).add(node.val);
            dfs(result, node.left, level + 1);
            dfs(result, node.right, level + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode tree = TreeUtil.getTree("[3,9,20,null,null,15,7]");
        List<List<Integer>> lists = new Solution().levelOrder(tree);
        lists.forEach(System.out::println);

        System.out.println("---");

        lists = new Solution().levelOrder2(tree);
        lists.forEach(System.out::println);
    }
}
