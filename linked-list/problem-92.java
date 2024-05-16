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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        int count = 0;

        ListNode breakPt1 = null;
        ListNode breakPt2;
        ListNode curr = dummyNode;

        while (count < right) {
            if (count == left -1 ) {
                breakPt1 = curr;
            }
            curr = curr.next;
            count++;
        }
        breakPt2 = curr.next;
        curr.next = null;
        breakPt1.next = reverseLL(breakPt1.next);

        while (breakPt1.next != null) {
            breakPt1 = breakPt1.next;
        }
        breakPt1.next = breakPt2;
        return dummyNode.next;
    }

    private ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode temp;
        while (head != null) {
            temp = head.next;
            head.next = prev;
            prev=head;
            head = temp;
        }
        return prev;
    }
}