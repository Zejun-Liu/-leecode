package com.jiuxian;

import com.jiuxian.util.TreeNode;
import com.jiuxian.util.TreeUtil;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: liuzejun
 * *
 * @email: 857591294@qq.com
 * *
 * @date: 2019-07-21 22:26:52
 * *
 * @comment: 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A20190721_01_MaximumDepthOfBinaryTree_104 {

    private static class Solution {
        int maxDepth(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            cal(root, 1, list);
            list.sort((t1, t2) -> t2 - t1);
            return list.isEmpty() ? 0 : list.get(0);
        }

        private void cal(TreeNode node, int level, List<Integer> list) {
            if (node == null) return;
            list.add(level);
            cal(node.left, level + 1, list);
            cal(node.right, level + 1, list);
        }

        int maxDepth2(TreeNode root) {
            if (root == null) return 0;
            LinkedList<TreeNode> list = new LinkedList<>();
            list.addLast(root);

            int max = 0;
            while (!list.isEmpty()) {
                int len = list.size();
                for (int i = 0; i < len; i++) {
                    TreeNode node = list.removeFirst();
                    if (node.left != null) {
                        list.addLast(node.left);
                    }
                    if (node.right != null) {
                        list.addLast(node.right);
                    }
                }
                max++;
            }
            return max;
        }

        int maxDepth3(TreeNode root) {
            if (root == null) return 0;
            return 1 + Math.max(maxDepth3(root.left), maxDepth3(root.right));
        }
    }

    public static void main(String[] args) {
        TreeNode tree = TreeUtil.getTree("[3,9,20,null,null,15,7]");
        int i = new Solution().maxDepth3(tree);
        System.out.println(i);
        Assert.assertEquals(3, i);
    }
}
