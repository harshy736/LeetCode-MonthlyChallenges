/*
659. Split Array into Consecutive Subsequences
Medium

You are given an integer array nums that is sorted in non-decreasing order.

Determine if it is possible to split nums into one or more subsequences such that both of the following conditions are true:

Each subsequence is a consecutive increasing sequence (i.e. each integer is exactly one more than the previous integer).
All subsequences have a length of 3 or more.
Return true if you can split nums according to the above conditions, or false otherwise.

A subsequence of an array is a new array that is formed from the original array by deleting some (can be none) of the elements without disturbing the relative positions of the remaining elements. (i.e., [1,3,5] is a subsequence of [1,2,3,4,5] while [1,3,2] is not).

Example 1:

Input: nums = [1,2,3,3,4,5]
Output: true
Explanation: nums can be split into the following subsequences:
[1,2,3,3,4,5] --> 1, 2, 3
[1,2,3,3,4,5] --> 3, 4, 5
Example 2:

Input: nums = [1,2,3,3,4,4,5,5]
Output: true
Explanation: nums can be split into the following subsequences:
[1,2,3,3,4,4,5,5] --> 1, 2, 3, 4, 5
[1,2,3,3,4,4,5,5] --> 3, 4, 5
Example 3:

Input: nums = [1,2,3,4,4,5]
Output: false
Explanation: It is impossible to split nums into consecutive increasing subsequences of length 3 or more.
 

Constraints:

1 <= nums.length <= 104
-1000 <= nums[i] <= 1000
nums is sorted in non-decreasing order.
*/
class Solution {
    public boolean isPossible(int[] nums) {//NOT
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> end = new HashMap<>();//stoees end  of every valid subsequence
        //helps if someone wants to add in this simply add
        
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        //if anyone has not added in the valid subsequence -> then try to make a 3 length valid subsequence from it
        
        for(int num : nums){
            if(freq.get(num) == 0)//aded in a valid subsequnce -> already handled
                continue;
            
            //if this number can be added in previous valiud
            if(end.containsKey(num - 1)){//add in this valid 
                if(end.get(num - 1) > 1)
                    end.put(num - 1, end.get(num - 1) - 1);
                else
                    end.remove(num - 1);
                
                //put for updated 
                end.put(num, end.getOrDefault(num, 0) + 1);
                freq.put(num, freq.get(num) - 1);
            }else{//try to make valid subsequence
                for(int i = 0; i < 3; i++){
                    if(!freq.containsKey(num + i) || freq.get(num + i) == 0)
                        return false;
                    
                    freq.put(num + i, freq.get(num + i) - 1);
                }
                
                end.put(num + 2, end.getOrDefault(num + 2, 0) + 1);
            }
        }
        
        return true;
    }
}
