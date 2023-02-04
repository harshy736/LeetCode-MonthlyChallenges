/*
567. Permutation in String
Medium
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();

        if(len1 > len2)
            return false;
        
        int[] freq = new int[26];
        
        //fill req freq
        for(char ch : s1.toCharArray()){
            freq[ch -'a']--;
        }
        
        //using sliding window
        //fill available
        for(int i = 0; i < len2; i++){
            char ch = s2.charAt(i);

            freq[ch - 'a']++;

            if(i >= len1)
                freq[s2.charAt(i - len1) - 'a']--;

            if(i >= len1 - 1){
                if(isPermutation(freq)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isPermutation(int[] freq){
        boolean isPer = true;
        for(int i = 0; i < 26; i++){
            if(freq[i] != 0){
                isPer = false;
                break;
            }
        }

        return isPer;
    }
}
