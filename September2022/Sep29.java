/*
658. Find K Closest Elements
Medium

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
 

Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104
*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int pos = 0, n  = arr.length;
        
        for( ; pos < n; pos++){
            if(arr[pos] >= x)
                break;
        }
        
        int l = pos - 1, r = pos;
        
        while(k-- > 0){
            if(l < 0){
                r++;
            }else if(r >= n){
                l--;
            }else{
                if(x - arr[l] <= arr[r] - x){
                    l--;
                }else{
                    r++;
                }
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i = l + 1; i < r; i++){
            res.add(arr[i]);
        }
        
        return res;
    }
}
