/*
76. Minimum Window Substring
Hard

13218

581

Add to List

Share
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 

Follow up: Could you find an algorithm that runs in O(m + n) time?
*/

class Solution {
    HashMap<Character, Integer> tar;
    public String minWindow(String s, String t) {
        String ans = "";
        
        tar = new HashMap<>();
        for(char ch : t.toCharArray()){
            tar.put(ch, tar.getOrDefault(ch, 0) + 1);
        }
        
        HashMap<Character, Integer> freq = new HashMap<>();
        int n = s.length();
        int prev = 0;
        
        for(int i = 0; i < n; i++){
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
            if(isEqual(freq)){//valid substring from prev to i
                //try to reduce substring as much possible
                while(prev < i){
                    if(!tar.containsKey(s.charAt(prev)) || freq.get(s.charAt(prev)) > tar.get(s.charAt(prev))){
                        freq.put(s.charAt(prev), freq.get(s.charAt(prev)) - 1);
                    }else{
                        break;
                    }
                    prev++;
                }
                      
                int len = i - prev + 1;
                if(ans.length() == 0 || ans.length() > len){
                    ans = s.substring(prev, i + 1);
                }
        
                //remove prev also -> to avoid repetitive on same substring
                freq.put(s.charAt(prev), freq.get(s.charAt(prev)) - 1);
                prev++;
            }
        }
        
        return ans;
    }

    
    private boolean isEqual(HashMap<Character, Integer> freq){
        for(char ch : tar.keySet()){
            if(!freq.containsKey(ch) || tar.get(ch) > freq.get(ch))
                return false;
        }
        
        return true;
    }
}
