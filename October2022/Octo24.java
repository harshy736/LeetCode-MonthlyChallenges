/*
1239. Maximum Length of a Concatenated String with Unique Characters
Medium

2863

201

Add to List

Share
You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.

Return the maximum possible length of s.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All the valid concatenations are:
- ""
- "un"
- "iq"
- "ue"
- "uniq" ("un" + "iq")
- "ique" ("iq" + "ue")
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
Explanation: The only string in arr has all 26 characters.
 

Constraints:

1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] contains only lowercase English letter
*/

class Solution {
    public int maxLength(List<String> arr) {
        List<Integer> dp = new ArrayList<>();//containning every possible comb
        //store int -> ith bit 1 - ith char +nt
        
        dp.add(0);
        int res = 0;
        
        for (String s : arr) {
          int cMask = 0, dup = 0;
            
          for (char c : s.toCharArray()) {
            dup |= cMask & (1 << (c - 'a'));
            cMask |= 1 << (c - 'a');
          }
          //cMask -> stores char of s in int
            
          if (dup > 0)    
              continue;//a str has non unique char
            
          for (int i = dp.size() - 1; i >= 0; i--) {
            if((cMask & dp.get(i)) == 0){//if unique strings
              dp.add(cMask | dp.get(i));//add new subseq
            }
          }
        }
        
        for(int mask : dp){
            res = Math.max(res, Integer.bitCount(mask));
        }
        
        return res;
    }
}
