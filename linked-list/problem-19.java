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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        int count = 0;
        ListNode nodeToDelete = dummyNode;
        ListNode leadingNode = dummyNode;


        while(count<n){
            count++;
            leadingNode = leadingNode.next;
        }

        while (leadingNode.next != null) {
            leadingNode = leadingNode.next;
            nodeToDelete = nodeToDelete.next;
        }

        nodeToDelete.next = nodeToDelete.next.next;

        return dummyNode.next;
    }
}