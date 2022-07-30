/*
916. Word Subsets
Medium

You are given two string arrays words1 and words2.

A string b is a subset of string a if every letter in b occurs in a including multiplicity.

For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.

Return an array of all the universal strings in words1. You may return the answer in any order.

Example 1:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
Output: ["facebook","google","leetcode"]
Example 2:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
Output: ["apple","google","leetcode"]
 

Constraints:

1 <= words1.length, words2.length <= 104
1 <= words1[i].length, words2[i].length <= 10
words1[i] and words2[i] consist only of lowercase English letters.
All the strings of words1 are unique.
*/
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        //all strings in words2
        //subset of words1 for universal
        //I can take maximum count for every charcter in words2
        
        int[] freqMax = new int[26];
        
        for(String word : words2){
            int[] freq = new int[26];
                
            for(char ch : word.toCharArray()){
                freq[ch - 'a']++;
            }
            
            //maximum for every case
            for(int i = 0; i < 26; i++){
                freqMax[i] = Math.max(freqMax[i], freq[i]);
            }
        }
        
        //freqMax -> tale consider of extreme case if word satisfy this then should satisfy for all word
        
        List<String> res = new ArrayList<>();
        for(String word : words1){
            int[] freq = new int[26];
                
            for(char ch : word.toCharArray()){
                freq[ch - 'a']++;
            }
            
            boolean isUniversal = true;
            for(int i = 0; i < 26; i++){
                if(freq[i] < freqMax[i]){
                    isUniversal = false;
                    break;
                }
            }
            
            if(isUniversal){
                res.add(word);
            }
        }
        
        return res;
    }
}
