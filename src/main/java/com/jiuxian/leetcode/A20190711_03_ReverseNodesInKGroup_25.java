package com.jiuxian.leetcode;

/**
 * @author: liuzejun
 * *
 * @email: 857591294@qq.com
 * *
 * @date: 2019-07-11 16:52:58
 * *
 * @description: 25. Reverse Nodes in k-Group
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
@SuppressWarnings({ "Duplicates", "AlibabaLowerCamelCaseVariableNaming" })
public class A20190711_03_ReverseNodesInKGroup_25 {

    private ListNode reverseKGroup(ListNode head, int k) {

        ListNode result = new ListNode(0);
        result.next = head;

        ListNode pre = result;
        ListNode end = result;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;

            end.next = null;

            pre.next = reverse(start);
            start.next = next;

            pre = start;

            end = pre;
        }
        return result.next;
    }


    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{val=" + val + ", next=" + next + "}";
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        node.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        node2.next = new ListNode(4);

        System.out.println(node);
        ListNode node4 = new A20190711_03_ReverseNodesInKGroup_25().reverseKGroup(node, 3);
        System.out.println(node4);
    }
}
