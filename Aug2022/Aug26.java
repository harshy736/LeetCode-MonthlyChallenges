/*
869. Reordered Power of 2
You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.

Return true if and only if we can do this so that the resulting number is a power of two.

Example 1:

Input: n = 1
Output: true
Example 2:

Input: n = 10
Output: false
 

Constraints:

1 <= n <= 109
*/

class Solution {
    public boolean reorderedPowerOf2(int n) {
        int cand = 1;
        
        int[] freq = new int[10];
        int tmp = n;
        while(tmp > 0){
            freq[tmp % 10]++;
            tmp /= 10;
        }
        
        for(int i = 0; i < 31; i++){
            int val = (int)(Math.pow(2, i));
            int[] freq2 = new int[10];
            
            while(val > 0){
                freq2[val % 10]++;
                val /= 10;
            }
            
            if(isEqual(freq, freq2))
                return true;
        }
        
        return false;
    }
    
    private boolean isEqual(int[] f1, int[] f2){
        for(int i = 0; i < 10; i++){
            if(f1[i] != f2[i])
                return false;
        }
        
        return true;
    }
}
