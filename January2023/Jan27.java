/*
472. Concatenated Words
Hard
Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.

A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

Example 1:

Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
"dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
Example 2:

Input: words = ["cat","dog","catdog"]
Output: ["catdog"]
 
Constraints:

1 <= words.length <= 104
1 <= words[i].length <= 30
words[i] consists of only lowercase English letters.
All the strings of words are unique.
1 <= sum(words[i].length) <= 105
*/

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {//help -> for speed only
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
    
        Arrays.sort(words, new Comparator<String>() {
           @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
    
        for (int i = 0; i < words.length; i++) {
            if (canBeComposed(words[i], set)) {
                res.add(words[i]);
            }
            set.add(words[i]);
        }
    
        return res;
    }
    
    private boolean canBeComposed(String word, Set<String> set) {
        boolean[] M = new boolean[word.length() + 1];
        M[0] = true;
        
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (M[j] == true && set.contains(word.substring(j, i))) {
                    M[i] = true;
                    break;
                }
            }
        }
        
        return M[M.length - 1];
    }
}
