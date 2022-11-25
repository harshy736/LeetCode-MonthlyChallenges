/*
907. Sum of Subarray Minimums
Medium
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444 

Constraints:

1 <= arr.length <= 3 * 104
1 <= arr[i] <= 3 * 104
*/

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = (int)(1e9 + 7);
        int n = arr.length;
        
        Stack<Integer> st = new Stack<>();
        
        long ans  = 0;
        
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                int curr = st.pop();
                int prevSmaller = st.isEmpty() ? -1 : st.peek();
                int nextSmaller = i;
                
                long count = 1L * (curr - prevSmaller) * (nextSmaller - curr) * arr[curr];
                
                ans = (ans + count) % MOD;
            }
            
            st.push(i);
        }
        
        //
       
        while(!st.isEmpty()){
            int curr = st.pop();
            int prevSmaller = st.isEmpty() ? -1 : st.peek();   
            int nextSmaller = n;
            
            long count = 1L * (curr - prevSmaller) * (nextSmaller - curr) * arr[curr];

            ans = (ans + count) % MOD;
            nextSmaller = curr;
        }
        
        return (int)ans;
    }
}
