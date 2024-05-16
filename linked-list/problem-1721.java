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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode startPointer = dummyNode;
        ListNode endPointer = dummyNode;
        ListNode startPointerCopy;
        int count = 0;

        while (count < k){
            count++;
            startPointer = startPointer.next;
        }
        startPointerCopy = startPointer;

        while (startPointerCopy!= null) {
            startPointerCopy = startPointerCopy.next;
            endPointer = endPointer.next;
        }

        int temp = endPointer.val;
        endPointer.val = startPointer.val;
        startPointer.val = temp;

        return head;

    }
}