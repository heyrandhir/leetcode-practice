// problem statement https://www.geeksforgeeks.org/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list/1

class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        Node dummyNode = new Node();
        dummyNode.next = head;
        
        Node prev = dummyNode;
        
        while (head != null) {
            if (head.data == x) {
                Node temp = head.next;
                prev.next = head.next;
                if (head.next != null) {
                    head.next.prev = prev;
                }
                head.next = null;
                head.prev= null;
                head = temp;
            } else {
                prev = head;
                head = head.next;
            }
        }
        
        return dummyNode.next;
    }
}