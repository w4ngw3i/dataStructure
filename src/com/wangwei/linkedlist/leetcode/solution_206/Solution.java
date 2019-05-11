package com.wangwei.linkedlist.leetcode.solution_206;

import com.wangwei.linkedlist.leetcode.ListNode;
import com.wangwei.linkedlist.leetcode.solution_203.Solution2;

/**
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null){

            if (cur.next == null){
                dummyHead.next = new ListNode(cur.next.val);
                cur.next = null;

                reverseList()
            }else
                cur = cur.next;
        }

        return cur;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode listNode = new ListNode(nums);
        System.out.println(listNode);

        System.out.println(new Solution().reverseList(listNode));
    }
}
