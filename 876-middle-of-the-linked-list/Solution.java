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
    public ListNode middleNode(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        
        // check if current node(fast) and its next node is ending 
        while(fast != null && fast.next != null) {
            // increase by 1 to reach mid
            slow = slow.next;
            // increase by 2 to reach end
            fast = fast.next.next;
        }
        return slow;
    }
}