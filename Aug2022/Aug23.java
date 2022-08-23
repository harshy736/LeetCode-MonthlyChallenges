/*
234. Palindrome Linked List
Easy

Given the head of a singly linked list, return true if it is a palindrome. 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 

Follow up: Could you do it in O(n) time and O(1) space?
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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        
        //divide LL into 2 parts
        //slow -> mid point
        ListNode slow = head, fast = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if(fast.next != null)//even length
            slow = slow.next;
        
        //reverse 2nd part
        ListNode right = reverse(slow);
        ListNode left = head;
        
        //check lineraly for pallindrome
        while(left != null && right != null){
            if(left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        
        return true;
    }
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        
        ListNode forw = head, curr = head, prev = null;
        
        while(curr != null){
            forw = curr.next;// store forward
            curr.next = prev;//reverse
            
            //update
            prev = curr;
            curr = forw;
        }
        
        return prev;
    }
}
