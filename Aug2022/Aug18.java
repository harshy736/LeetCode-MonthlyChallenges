/*
1338. Reduce Array Size to The Half
Medium

You are given an integer array arr. You can choose a set of integers and remove all the occurrences of these integers in the array.

Return the minimum size of the set so that at least half of the integers of the array are removed.

Example 1:

Input: arr = [3,3,3,3,5,5,5,2,2,7]
Output: 2
Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
Possible sets of size 2 are {3,5},{3,2},{5,2}.
Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has a size greater than half of the size of the old array.
Example 2:

Input: arr = [7,7,7,7,7,7]
Output: 1
Explanation: The only possible set you can choose is {7}. This will make the new array empty.

Constraints:

2 <= arr.length <= 105
arr.length is even.
1 <= arr[i] <= 105
*/
class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int val : arr){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        
        int size = map.size();
        int[] freq = new int[size];
        
        int idx = 0;
        for(int key : map.keySet()){
            freq[idx++] = map.get(key);
        }
        
        Arrays.sort(freq);
        
        int tarRem = arr.length / 2;
        int count = 0;
        
        for(int i = size - 1; i >= 0; i--){
            tarRem -= freq[i];
            count++;
            
            if(tarRem <= 0)
                break;
        }
        
        return count;
    }
}
