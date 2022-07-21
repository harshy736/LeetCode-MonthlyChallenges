/*
92. Reverse Linked List II
Medium

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

Example 1:

Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]
 
Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
 
Follow up: Could you do it in one pass?
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null)
            return head;
        
        ListNode curr = head, prev = null, startTail = null, rEnd = null;
      
        for(int i = 1; i <= right; i++){
            if(i == left - 1){
                startTail = curr;
            }else if(i == left)
                rEnd = curr;
            
            if(i < left){
                prev = curr;
                curr = curr.next;
            }else if(i >= left){
                //reverse
                ListNode forw = curr.next;///link to LL
                
                curr.next = prev;//reverse
                
                //move
                prev = curr;
                curr = forw;
            }
        }
        
        ListNode secondHead = curr;
        ListNode rHead = prev;
        
        //link
        if(rEnd != null)
            rEnd.next = secondHead;
        
        if(startTail != null){
            startTail.next = rHead;
        }else{
            head = rHead;
        }
        
        return head;
    }
}
