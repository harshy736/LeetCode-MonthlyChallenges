/*
290. Word Pattern

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
        if(words.length != pattern.length())//unequal length -> matching not possible
            return false;
        
        HashMap<String, Character> map = new HashMap<>();
        
        for(int i = 0; i < words.length; i++){
            char tar = pattern.charAt(i);
            
            if(map.containsKey(words[i])){
                if(map.get(words[i]) != tar)
                    return false;
            }else if(map.containsValue(tar))//wrong mapping -> impossible
                return false;
            else
                map.put(words[i], tar);
        }
        
        return true;
    }
}
