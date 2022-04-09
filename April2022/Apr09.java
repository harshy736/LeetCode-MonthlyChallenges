/*
347. Top K Frequent Elements
Medium

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 
Constraints:

1 <= nums.length <= 105
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 
Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

public class Pair implements Comparable<Pair>{
    int first, second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }

    public int compareTo(Pair o){
       return o.second - this.second;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }
        
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            Pair rem = pq.poll();
            ans[i] = rem.first;    
        }
         
        return ans;
    }
    
}
