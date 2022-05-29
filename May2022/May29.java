/*
318. Maximum Product of Word Lengths
Medium

Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. If no such two words exist, return 0.
Example 1:

Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".
Example 2:

Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".
Example 3:

Input: words = ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.
 
Constraints:

2 <= words.length <= 1000
1 <= words[i].length <= 1000
words[i] consists only of lowercase English letters.
*/
class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] mask = new int[n];
        
        for(int i = 0; i < n; i++){
            int val = 0;
            
            for(char ch : words[i].toCharArray()){
                val |= (1 << (ch - 'a'));
            }
            mask[i] = val;
        }
        
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if((mask[i] & mask[j]) == 0){//no intersectionn
                    int len1 = words[i].length(), len2 = words[j].length();
                    ans = Math.max(ans, len1 * len2);
                }
            }
        }
        
        return ans;
    }
}
