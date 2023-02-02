/*
953. Verifying an Alien Dictionary
Easy
In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 
Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are English lowercase letters.
*/

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int n = words.length;

        int[] rank = new int[26];
        for(int i = 0; i < 26; i++){
            rank[order.charAt(i) - 'a'] = i;
        }

        for(int i = 1; i < n; i++){
            if(!isSorted(words[i - 1], words[i], rank))
                return false;
        }

        return true;
    }

    public boolean isSorted(String s1, String s2, int[] rank){
        int len = Math.min(s1.length(), s2.length());

        for(int i = 0; i < len; i++){
            if(s1.charAt(i) == s2.charAt(i))
                continue;

            if(rank[s1.charAt(i) - 'a'] < rank[s2.charAt(i) - 'a'])
                return true;
            else// > 
                return false;
        }

        //if both string has same prefix -> now which one is smaller in size then it is lex smaller 

        return s1.length() <= s2.length() ? true : false;
    }
}
