/*
912. Sort an Array
Medium
Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessairly unique.
 

Constraints:

1 <= nums.length <= 5 * 104
-5 * 104 <= nums[i] <= 5 * 104
*/

class Solution {
    public int[] sortArray(int[] nums) {
        //using meregr sort - Top Down approach - Inplace
        mergeSort(nums, 0, nums.length);
        return nums;
    }
    
    private void mergeSort(int[] nums, int s, int e){
        if((e - s) == 1){//single elememt
            return;
        }
        
        int mid = (s + e) / 2;
        mergeSort(nums,s, mid);//1t part
        mergeSort(nums, mid, e);//2nd part
        
        merge(nums, s, mid, e);//merge soted arrays
    }
    
    private void merge(int[] nums, int s, int mid, int e){
        int[] ans = new int[e - s];
        int k = 0, l = s, r = mid;
        
        while(l < mid && r < e){
            if(nums[l] <= nums[r])
                ans[k] = nums[l++];
            else
                ans[k] = nums[r++];
            
            k++;
        }
        
        while(l < mid){
            ans[k++] = nums[l++];
        }
        
        while(r < e){
            ans[k++] = nums[r++];
        }
        
        for(int i = 0; i < ans.length; i++){
            nums[s + i] = ans[i];
        }
    }
}
