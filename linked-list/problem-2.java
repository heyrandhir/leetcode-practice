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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;
        int carry = 0;
        while (l1 != null && l2 != null) {
            ListNode sum = new ListNode((l1.val+l2.val+carry)%10);
            carry = (l1.val+l2.val+carry)/10;
            res.next = sum;
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            ListNode sum = new ListNode((l1.val+carry)%10);
            carry = (l1.val+carry)/10;
            res.next = sum;
            res = res.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            ListNode sum = new ListNode((l2.val+carry)%10);
            carry = (l2.val+carry)/10;
            res.next = sum;
            res = res.next;
            l2 = l2.next;
        }

        if (carry != 0) {
            ListNode sum = new ListNode(carry%10);
            res.next = sum;
        }

        return dummyNode.next;
    }
}