package com.jiuxian.leetcode;

import com.jiuxian.leetcode.util.TreeNode;
import com.jiuxian.leetcode.util.TreeUtil;
import org.junit.Assert;

/**
 * @author: liuzejun
 * *
 * @email: 857591294@qq.com
 * *
 * @date: 2019-07-21 23:01:39
 * *
 * @comment: 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A20190721_02_MinimumDepthOfBinaryTree_111 {

    private static class Solution {
        int minDepth(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null) return minDepth(root.right) + 1;
            if (root.right == null) return minDepth(root.left) + 1;
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }

        int minDepth2(TreeNode root) {
            if (root == null) return 0;
            int left = minDepth2(root.left);
            int right = minDepth2(root.right);
            return (left == 0 || right == 0) ? left + right + 1 :
                    (1 + Math.min(left, right));
        }
    }

    public static void main(String[] args) {
        TreeNode tree = TreeUtil.getTree("[1,2]");
        int i = new Solution().minDepth2(tree);
        System.out.println(i);
        Assert.assertEquals(2, i);
    }
}
