package com.leetcode.twopointer;

/**
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * Return the linked list sorted as well.
 * https://www.youtube.com/watch?v=YIg9vHTRpQE for explanation.
 * */
public class RemoveDupsFromSortedLinkedList2 {

  public static ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy, prev, cur = head , next = head.next;
        dummy = new ListNode(0);
        dummy.next = head;
        prev = dummy;

        while (next != null) {
            if (cur.val != next.val) {
                prev = cur;
                cur = next;
                next = next.next;
            } else {
                while (next != null && cur.val == next.val) {
                    next = next.next;
                }
                prev.next = next;
                cur = next;
                next = (next != null) ? next.next : null;
            }
        }
        return dummy.next;
  }

    public static void main(String[] args) {

        ListNode head3 = new ListNode(1);
        ListNode head31 = new ListNode(1);
        head3.next = head31;


        printNode(removeDuplicates(head3));

        ListNode head4 = new ListNode(4);
        ListNode head41 = new ListNode(4);
        ListNode head42 = new ListNode(4);
        ListNode head43 = new ListNode(4);
        head4.next = head41;
        head41.next = head42;
        head42.next = head43;
        printNode(removeDuplicates(head4));

        /*ListNode head = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(4);
        ListNode node8 = new ListNode(5);

        head.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        printNode(removeDuplicates(head));

        ListNode head21 = new ListNode(1);
        ListNode node22 = new ListNode(1);
        ListNode node23 = new ListNode(1);
        ListNode node24 = new ListNode(2);
        ListNode node25 = new ListNode(3);
        head21.next = node22;
        node22.next = node23;
        node23.next = node24;
        node24.next = node25;

        printNode(removeDuplicates(head21)); */
    }

    public static void printNode(ListNode node) {
      while (node != null) {
          System.out.print(node.val + " ");
          node = node.next;
      }
        System.out.println();
    }
}
