/*
143. Reorder List

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 

Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
*/

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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)//reorder not possible
            return;
        
        ListNode slow = head, fast = head.next;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = reverse(slow.next);
        slow.next = null;
        
        ListNode curr1 = head, curr2 = head2, forw1 = null, forw2 = null, prev = null;
        
        while(curr1 != null){
            forw1 = curr1.next;
            forw2 = curr2.next;
            
            curr1.next = curr2;
            curr2.next = null;
            
            if(prev != null)
                prev.next = curr1;
            
            prev = curr2;
            
            curr1 = forw1;
            curr2 = forw2;
        }
        if(curr2 != null)
            prev.next = curr2;
        
    }
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null)return head;
        
        ListNode curr = head.next, prev = head, forw = null;
        prev.next = null;
        
        while(curr != null){
            forw = curr.next;
            
            curr.next = prev;
            prev = curr;
            
            curr = forw;
        }
        
        return prev;
    }
}
