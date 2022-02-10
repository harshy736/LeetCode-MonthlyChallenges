/*
560. Subarray Sum Equals K
Medium
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        //now o(n) solution
        //Using HashMap
        
        //Stroring prevsum in the hashmap
        //just like c[j] - c[i] // c[i] is always stored in the hashmap -> O(1)
        //if our curSum == k, count++
        //else search for c[i]which is calculated from c[j] - c[i] = k
        //c[i] = c[j] - k;
        //if we find this c[i] in hashmap increase count by number of subarrays having this value of c[i]
        
        HashMap<Integer, Integer> map = new HashMap<>();
        //Sum -> freq
        map.put(0, 1);//empty array sum
        
        int count = 0, csum = 0;
        for(int i = 0; i < n; i++){
            csum += nums[i];//adding this element
            
            //if c[i] exists where c[j] - c[i] == k
            if(map.containsKey(csum - k))
                count += map.get(csum - k);
            
            //storing freq
            int prev = map.getOrDefault(csum, 0);
            
            //increasing frequency of this value by 1
            map.put(csum, prev + 1);
        }
        
        return count;
    }
}
