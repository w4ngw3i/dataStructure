package com.wangwei.exer.linklist;

import java.util.Objects;

/**
 * @Author wangwei
 * @Date 2020/5/5 1:57 下午
 * @Version 1.0
 */
public class Solution203ByRec {
   public ListNode removeElements(ListNode head, int val) {
       if (Objects.isNull(head)) {
           return null;
       }
       ListNode delNode = removeElements(head.next, val);
       if (Objects.equals(head.val, val)){
           return delNode;
       }else {
           head.next = delNode;
           return head;
       }
   }
}
