/*
1207. Unique Number of Occurrences
Easy

2749

61

Add to List

Share
Given an array of integers arr, return true if the number of occurrences of each value in the array is unique, or false otherwise.

 

Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
 

Constraints:

1 <= arr.length <= 1000
*/

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : arr)
            map.put(val, map.getOrDefault(val, 0) + 1);
        
        HashSet<Integer> set = new HashSet<>();
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(set.contains(entry.getValue()))
                return false;
            
            set.add(entry.getValue());
        }
        
        return true;
    }
}
