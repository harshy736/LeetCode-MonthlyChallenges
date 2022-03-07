/*
21. Merge Two Sorted Lists
Easy

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 
Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }else if(l2 == null)
            return l1;
        
        ListNode h1 = l1, h2 = l2;
        ListNode head = new ListNode(-1), tmp = head;
        
        //run until one list is finished
        while(h1 != null && h2 != null){
            if(h1.val <= h2.val){
                tmp.next = h1;
                h1 = h1.next;
            }else{
                tmp.next = h2;
                h2 = h2.next;
            }
            
            tmp = tmp.next;
        }
        
        //remaining list 1
        while(h1 != null){
            tmp.next = h1;
            h1 = h1.next;
            tmp = tmp.next;
        }
        
        //rem list 2
        while(h2 != null){
            tmp.next = h2;
            h2 = h2.next;
            tmp = tmp.next;
        }
        
        //removing dummy node
        head = head.next;
        
        return head;
    }
}
