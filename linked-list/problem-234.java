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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;

        while (fast.next != null && fast.next.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = slow.next;
        slow.next = null;
        if (fast.next != null)
            fast = fast.next;

        ListNode reveresedSecondHalfLL = reverseLL(temp);

        while (head != null && reveresedSecondHalfLL != null) {
            if (head.val != reveresedSecondHalfLL.val)
                return false;
            head = head.next;
            reveresedSecondHalfLL = reveresedSecondHalfLL.next;
        }
        return true;
    }

    private ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode temp;
        while ( head != null) {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}