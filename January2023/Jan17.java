/*
926. Flip String to Monotone Increasing
Medium
A binary string is monotone increasing if it consists of some number of 0's (possibly none), followed by some number of 1's (also possibly none).

You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.

Return the minimum number of flips to make s monotone increasing.

Example 1:

Input: s = "00110"
Output: 1
Explanation: We flip the last digit to get 00111.
Example 2:

Input: s = "010110"
Output: 2
Explanation: We flip to get 011111, or alternatively 000111.
Example 3:

Input: s = "00011000"
Output: 2
Explanation: We flip to get 00000000.
 
Constraints:

1 <= s.length <= 105
s[i] is either '0' or '1'.
*/

class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();

        int[] count = new int[n];//count no of 1s upto ith index

        for(int i = 0; i < n; i++){
            if(i > 0)
                count[i] = count[i - 1];

            if(s.charAt(i) == '1')
                count[i]++;
        }

        int ans = n - count[n - 1];//remove all zeroes -> all 1

        //now check for every pos -> upto that pos all 0 and after all 1

        for(int i = 0; i < n; i++){
            //remove 1s in first part and 0s in 2nd part

            int rem1 = count[i];
            int rem0 = n - i - 1  - (count[n - 1] - count[i]);//count[n - 1] - count[i] -> gives 1s in part2

            ans = Math.min(ans, rem1 + rem0);
        }

        return ans;
    }
}
