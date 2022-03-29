/*
287. Find the Duplicate Number
Medium

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
 
Constraints:

1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
 
Follow up:

How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?
*/
class Solution {
    public int findDuplicate(int[] nums) {//definitely not
        //By cycle
        //If we can reach same place of se start from same position - cycle is +nt
        //Cycle +nt -> means atleast 2 pointers points to a single posititon -> duplicate numbers
        //val as next posititon
        //Same as linked list cycle
        int slow = nums[0], fast = nums[0];
        
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);//run until doesnot find same node
        
        //staring point is equidistant from fast and head
        slow = nums[0];
        
        //gives starting node
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
       
        return slow;
    }
    
}
