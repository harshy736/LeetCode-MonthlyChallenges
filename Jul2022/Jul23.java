/*
315. Count of Smaller Numbers After Self
Hard

You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example 1:

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Example 2:

Input: nums = [-1]
Output: [0]
Example 3:

Input: nums = [-1,-1]
Output: [0,0]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
*/
class Solution {
    public List<Integer> countSmaller(int[] nums) {//Using MergeSort
        int[] counts = new int[nums.length];
        
        mergeSort(nums, 0, nums.length - 1, counts);
        
        List<Integer> ans = new ArrayList<>();
        for(int val : counts)
            ans.add(val);
        
        return ans;
    }
    
    private void mergeSort(int[] nums, int s, int e, int[] counts){
        if(s == e)
            return;
        
        int mid = s + (e - s) / 2;
        
        //right
        mergeSort(nums, mid + 1, e, counts);
        
        //Check smaller in right
        for(int i = s; i <= mid; i++){
            int lo = mid + 1, hi = e;
            int idx = mid;
            
            while(lo <= hi){
                int m = lo + (hi - lo) / 2;
                
                if(nums[i] > nums[m]){
                    idx = m;
                    lo = m + 1;
                }else{
                    hi = m - 1;
                }
            }
            
            counts[i] += (idx - mid);
        }
        
        //then left part
        mergeSort(nums, s, mid, counts);
        
        merge(nums, s, mid, e);
    }
    
    private void merge(int[] nums, int s, int mid, int e){
        int[] tmp = new int[e - s + 1];
        int i = s, j = mid + 1, k = 0;
        
        while(i <= mid && j <= e){
            if(nums[i] <= nums[j]){
                tmp[k++] = nums[i++];
            }else{
                tmp[k++] = nums[j++];
            }
        }
        
        while(i <= mid){
            tmp[k++] = nums[i++];
        }
        
        while(j <= e){
            tmp[k++] = nums[j++];
        }
        
        //copy back
        i = s;
        k = 0;
        while(i <= e){
            nums[i] = tmp[k];
            i++;
            k++;
        }
    }
}
