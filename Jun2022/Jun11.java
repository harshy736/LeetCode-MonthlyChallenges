/*
1658. Minimum Operations to Reduce X to Zero
Medium

You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.

Example 1:

Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
Example 2:

Input: nums = [5,6,7,8,9], x = 4
Output: -1
Example 3:

Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 
Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 104
1 <= x <= 109
*/
class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int[] csum = new int[n + 1];
        
        for(int i = 1; i <= n; i++){
            csum[i] = csum[i - 1] + nums[i - 1];
        }
        
        //removing elemnts from end & remove left elemnt according to the x
        int count = n + 1;
        
        for(int i = n; i >= 0; i--){
            int rsum = csum[n] - csum[i];
            int r = n - i;
            
            int tar = x - rsum;//left sum -> by start elemnt removal
            int l = binarySearch(csum, i, tar);
            
            int removed = l + r;
            count = Math.min(count, removed);
        }
        
        if(count > n)
            return -1;
        
        return count;
    }
    
    private int binarySearch(int[] csum, int e, int tar){
        int s = 0;
        //searching for elemnts removed from start to make x
        while(s <= e){
            int mid = (s + e) / 2;

            if(csum[mid] == tar){
                return mid;
            }else if(csum[mid] < tar){
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        
        return csum.length;
    }
}
