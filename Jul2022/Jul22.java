/*
86. Partition List
Medium

4118

536

Add to List

Share
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

 

Example 1:


Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
Example 2:

Input: head = [2,1], x = 2
Output: [1,2]
 

Constraints:

The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200
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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
            return head;
       
        ListNode dh1 = new ListNode(-1);
        ListNode dh2 = new ListNode(-1);
        ListNode curr1 = dh1, curr2 = dh2;
        
        ListNode curr = head;
        
        while(curr != null){
            if(curr.val < x){
                curr1.next = curr;
                curr1 = curr1.next;
            }else{
                curr2.next = curr;
                curr2 = curr2.next;
            }
            
            curr = curr.next;
        }
        
        //handle
        curr2.next = null;
        curr1.next = dh2.next;
        
        dh2.next = null;
        
        ListNode res = dh1.next;
        return res;
    }
}
