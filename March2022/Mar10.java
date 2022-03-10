/*
2. Add Two Numbers
Medium

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int s1 = 0, s2 = 0;
        ListNode tmp = l1, tail1 = l1;
        
        while(tmp != null){
            tmp = tmp.next;
            s1++;
        }
        
        tmp =  l2;
        while(tmp != null){
            tmp = tmp.next;
            s2++;
        }
        
        //always l1 is more in size -> we have to store our sum in it
        if(s2 > s1){
            tmp = l2;
            l2 = l1;
            l1 = tmp;
        }
        
        ListNode c1 = l1, c2 = l2;
        int sum = 0, carry = 0;
        while(c2 != null){
            sum = c1.val + c2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            
            //store in l1
            c1.val = sum;
            
            //move
            tail1 = c1;
            c1 = c1.next;
            c2 = c2.next;  
        }

        while(c1 != null){
            sum = c1.val + carry;
            carry = sum /10;
            sum = sum % 10;
            
            //store in l1
            c1.val = sum;
            
            //move
            tail1 = c1;
            c1 = c1.next;
        }
        
        if(carry == 1){
            tail1.next = new ListNode(1);
        }
        
        
        return l1;
    }

}
