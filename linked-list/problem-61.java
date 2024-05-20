/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0)
            return head;
        int actK = k % findSize(head);

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode fastPtr = dummyNode;
        ListNode slowPtr = dummyNode;

        int count = 0;
        while (count < actK) {
            fastPtr = fastPtr.next;
            count++;
        }

        while (fastPtr.next != null) {
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }

        ListNode temp = slowPtr.next;
        slowPtr.next = null;
        fastPtr.next = dummyNode.next;
        return temp;
    }

    public int findSize(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}