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
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null || k == 1)
            return head;
        
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curr = dummyNode;
        int count = 0;

        while (curr.next != null && count < k) {
            count++;
            curr = curr.next;
        }

        
        if (count < k)
            return head;
        
        ListNode tempNode = curr.next;
        curr.next = null;
        ListNode newHead = reverseLL(head);
        head.next = reverseKGroup(tempNode,k);
        return newHead;
    }

    private ListNode reverseLL(ListNode headPtr) {
        ListNode prev = null;
        ListNode temp = null;
        ListNode head = headPtr;

        while (head != null){
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}