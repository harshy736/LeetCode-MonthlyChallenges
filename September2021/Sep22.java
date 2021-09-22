//Maximum Length of a Concatenated String with Unique Characters
/*
Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.

Return the maximum possible length of s.

 

Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible solutions are "chaers" and "acters".
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
 

Constraints:

1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] contains only lower case English letters.
*/

class Solution {
    public int maxLength(List<String> arr) {
        List<Integer> dp = new ArrayList<>();//containning every possible comb
        //store int -> ith bit 1 - ith char +nt
        
        dp.add(0);
        int res = 0;
        for (String s : arr) {
          int a = 0, dup = 0;
          for (char c : s.toCharArray()) {
            dup |= a & (1 << (c - 'a'));
            a |= 1 << (c - 'a');
          }
          //a -> stores char of s in int
            
          if (dup > 0)    continue;//a str has non unique char
            
          for (int i = dp.size() - 1; i >= 0; i--) {
            if ((dp.get(i) & a) > 0) continue;//non unique -> move on
              
            dp.add(dp.get(i) | a);//add new subseq
            res = Math.max(res, Integer.bitCount(dp.get(i) | a));
          }
        }
        
        return res;
    }
}
