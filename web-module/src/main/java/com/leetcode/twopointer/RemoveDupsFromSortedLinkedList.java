package com.leetcode.twopointer;

/**
 * Given the head of a sorted linked list,
 * delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class RemoveDupsFromSortedLinkedList {

  public static ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy, left = head, right = head.next;
        dummy = new ListNode(0);
        dummy.next = head;
        while (right != null) {
            if (left.val == right.val) {
                if (right.next == null) {
                   left.next = null;
                }
                right = right.next;
            } else  {
                left.next = right;
                left = right;
                right = right.next;
            }
        }
        return head;
  }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        printNode(removeDuplicates(head));

        ListNode head1 = new ListNode(1);
        ListNode node6 = new ListNode(1);
        ListNode node7 = new ListNode(2);
        head1.next = node6;
        node6.next = node7;

        printNode(removeDuplicates(head1));
    }

    public static void printNode(ListNode node) {
      while (node != null) {
          System.out.print(node.val + " ");
          node = node.next;
      }
        System.out.println();
    }
}


// d -> head ->