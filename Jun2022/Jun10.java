/*
3. Longest Substring Without Repeating Characters
Medium

Given a string s, find the length of the longest substring without repeating characters.

 Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/
 class Solution {
    public int lengthOfLongestSubstring(String str) {
        int len = str.length();
        if(len == 0 || len == 1) return len;
        
        int s = 0, maxLen = 0;
        int[] prev = new int[256];
        Arrays.fill(prev, -1);
            
        for(int i = 0; i < len; i++){
            char ch = str.charAt(i);
            s = Math.max(s, prev[ch] + 1);
            maxLen = Math.max(i - s + 1, maxLen);
            prev[ch] = i;
        }
        
        return maxLen;
    }
}
