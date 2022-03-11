/*
61. Rotate List
Medium
Share
Given the head of a linked list, rotate the list to the right by k places.

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:

Input: head = [0,1,2], k = 4
Output: [2,0,1]
 
Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        
        int size = 0;
        ListNode slow = head, fast = head;
        
        while(slow != null){
            size++;
            slow = slow.next;
        }
        
        slow = head;
        k = k % size;//remove repeating repeation because repeation by size means no sense
        
        //kept distance between slow and fast by k
        while(k-- > 0){
            fast = fast.next;
        }
        
        //move both pointer until we last node
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        //slow.next -> next head
        //fast -> mergion node for head
        
        fast.next = head;//connect cyclic
        head = slow.next;//new head
        slow.next = null;//remove cycle
            
        return head;
    }
}
