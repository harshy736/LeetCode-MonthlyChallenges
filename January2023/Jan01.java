/*
290. Word Pattern
Easy

Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false

Constraints:

1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.
*/

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length())
            return false;

        int n = words.length;

        String[] mapping = new String[26];
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            int idx = pattern.charAt(i) - 'a';

            if(mapping[idx] != null){
                if(!mapping[idx].equals(words[i])){
                    return false;
                }
            }else if(set.contains(words[i])){//already words is mapped with another character
                return false;
            }

            mapping[idx] = words[i];
            set.add(words[i]);

        }

        return true;
    }
}
