/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        // bruteforce approach

        Set<ListNode> seen = new HashSet<ListNode>();

        while (head != null) {
            if (seen.contains(head))
                return true;
            seen.add(head);
            head = head.next;
        }
        return false;

        // optimized approach
        
        // if (head == null)
        //     return false;

        // ListNode fast = head;

        // while (fast.next != null && fast.next.next != null) {
        //     fast = fast.next.next;
        //     head = head.next;

        //     if (fast == head)
        //         return true;
        // }
        // return false;
    }
}