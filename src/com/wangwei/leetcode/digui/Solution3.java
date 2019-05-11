package com.wangwei.leetcode.digui;


import com.wangwei.leetcode.ListNode;

/**
 * @Auther wangwei
 * @Date 2018/5/27 下午5:20
 */
public class Solution3 {
    public ListNode removeElements(ListNode head, int val, int depth) {
        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("call: remove" + val + " in " + head);
        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return: " + head);
            return head;
        }

        ListNode res = removeElements(head.next, val, depth + 1);

        System.out.print(depthString);
        System.out.println("After remove: " + val + " : " + res);

        ListNode ret;
        if (head.val == val) {
            ret = res;
        } else {
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: " + ret);

        return ret;
    }

    private String generateDepthString(int depth) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            builder.append("--");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 7, 3, 5, 3, 9};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = new Solution3().removeElements(head, 3, 0);
        System.out.println(res);

    }
}
