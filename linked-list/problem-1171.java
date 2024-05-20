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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        HashMap<Integer,ListNode> memo = new HashMap<>();
        int prefixSum = 0;
        memo.put(prefixSum,dummyNode);

        while (head != null) {
            prefixSum += head.val;
            if (memo.containsKey(prefixSum)) {
                ListNode prev = memo.get(prefixSum);
                ListNode curr = prev.next;

                while (curr != head) {
                    prefixSum+= curr.val;
                    memo.remove(prefixSum);
                    curr = curr.next;
                }
                prefixSum+= head.val;
                prev.next = head.next;
                
            } else {
                memo.put(prefixSum,head);
            }
            head = head.next;
        }
        return dummyNode.next;
    }
}