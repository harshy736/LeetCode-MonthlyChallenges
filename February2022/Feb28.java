/*
228. Summary Ranges
Easy
You are given a sorted unique integer array nums.

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
 

Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
Example 2:

Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
 

Constraints:

0 <= nums.length <= 20
-231 <= nums[i] <= 231 - 1
All the values of nums are unique.
nums is sorted in ascending order.
*/
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if(nums.length == 0)
            return ans;
        else if(nums.length == 1){
            ans.add(nums[0] + "");
            return ans;
        }
        
        int sp = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(nums[sp]);
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[i - 1] != 1){//not come in previous range
                if(sp != i - 1)//not single element
                    sb.append("->").append(nums[i - 1]);
                
                ans.add(sb.toString());//add range to list
                
                sb.setLength(0);//clear previous range
                
                sp = i;//new rnge start from here
                sb.append(nums[sp]);
            }
        }
        
        //now for last element
        if(sp != nums.length - 1)//not single element
           sb.append("->").append(nums[nums.length - 1]);
        ans.add(sb.toString());
        
        return ans;
                
    }
}
