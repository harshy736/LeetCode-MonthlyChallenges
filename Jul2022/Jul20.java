/*
792. Number of Matching Subsequences

Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
 
Example 1:

Input: s = "abcde", words = ["a","bb","acd","ace"]
Output: 3
Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
Example 2:

Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
Output: 2

Constraints:

1 <= s.length <= 5 * 104
1 <= words.length <= 5000
1 <= words[i].length <= 50
s and words[i] consist of only lowercase English letters.
*/
class Solution {
    public int numMatchingSubseq(String s, String[] words) {//Other Method -> Help
        Deque<String>[] arr = new Deque[26];
        
        for(int i = 0; i < 26; i++){
            arr[i] = new ArrayDeque<>();
        }
        
        
        for(String word : words){
            arr[word.charAt(0) - 'a'].addLast(word);//stores word at their first index
        }
        
        int count = 0;
        
        for(char ch : s.toCharArray()){
            //remove first character of every string which start with ch
            
            int size = arr[ch - 'a'].size();
            
            for(int j = 0; j < size; j++){
                String word = arr[ch - 'a'].removeFirst();
                if(word.length() == 1){
                    count++;
                }else{
                    arr[word.charAt(1) - 'a'].addLast(word.substring(1));
                }
            }
        }
        
        return count;
    }
}
