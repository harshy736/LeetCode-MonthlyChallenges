/*
923. 3Sum With Multiplicity
Medium

1198

169

Add to List

Share
Given an integer array arr, and an integer target, return the number of tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.

As the answer can be very large, return it modulo 109 + 7.

 

Example 1:

Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
Output: 20
Explanation: 
Enumerating by the values (arr[i], arr[j], arr[k]):
(1, 2, 5) occurs 8 times;
(1, 3, 4) occurs 8 times;
(2, 2, 4) occurs 2 times;
(2, 3, 3) occurs 2 times.
Example 2:

Input: arr = [1,1,2,2,2,2], target = 5
Output: 12
Explanation: 
arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
We choose one 1 from [1,1] in 2 ways,
and two 2s from [2,2,2,2] in 6 ways.
 

Constraints:

3 <= arr.length <= 3000
0 <= arr[i] <= 100
0 <= target <= 300
*/
class Solution {
    public int threeSumMulti(int[] arr, int target) {//not
        //Arrays.sort(arr);
        int n = arr.length;
        long mod = (long)(1e9 + 7);
        
        if(n < 3)return 0;
        long ans = 0;
        
        long[] count = new long[101];
        
        int uniq = 0;
        for(int val : arr){
            count[val]++;
            if(count[val] == 1)
                uniq++;
        }
        
        int[] keys = new int[uniq];
        int t = 0;
        for (int i = 0; i <= 100; ++i)
            if (count[i] > 0)
                keys[t++] = i;
        
        for(int i = 0; i < uniq; i++){
            int j = i, k = uniq - 1, ntar = target - keys[i];
            int x = keys[i];
            
            while(j <= k){
                int y = keys[j], z = keys[k];
                if(y + z == ntar){
                    if(i < j && j < k){//elements are different
                        ans += count[x] * count[y] * count[z]; 
                    }else if(i == j & j < k){//first 2 elemts are same
                        ans += (count[x] * (count[x]  - 1) * count[z]) / 2 ;
                    }else if(i < j && j == k){//last 2 elements are same
                        ans += (count[x] * count[y] * (count[y] - 1)) / 2;         
                    }else{//all 3 elements are same
                        ans += (count[x] * (count[x] - 1) * (count[x] - 2)) / 6;
                    }
                    
                    ans = ans % mod;
                    j++;
                    k--;
                }else if(y + z < ntar){
                    j++;
                }else{
                    k--;
                }
            }
        }
        
        int res = (int)ans;
        return res;
    }
}
