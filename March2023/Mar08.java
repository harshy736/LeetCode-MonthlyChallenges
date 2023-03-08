/*
875. Koko Eating Bananas
Medium
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23 

Constraints:

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109
*/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        int len = piles.length;
        
        for(int i = 0; i < len; i++){
            if(piles[i] > max)
                max = piles[i];
        }
        //using binary search on value of k
        
        int k = 1;
        int lo = 1, hi = max;
        
        //now calculate hours to eat bananas with k value
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;

            long t = 0L;

            for(int i = 0; i < len; i++){
                t += piles[i] / mid;

                if(piles[i] % mid != 0)
                    t++;
            }
            
            if(t > h){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        
        return lo;
    }
}
