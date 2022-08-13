/*
30. Substring with Concatenation of All Words
Hard

2534

2015

Add to List

Share
You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.

You can return the answer in any order.

 

Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
Example 2:

Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []
Example 3:

Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]
 

Constraints:

1 <= s.length <= 104
1 <= words.length <= 5000
1 <= words[i].length <= 30
s and words[i] consist of lowercase English letters.
*/

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wlen = words[0].length();
        int wcnt = words.length;
        int n = s.length();
        
        List<Integer> res = new ArrayList<>();
        
        if(wcnt * wlen > n)
            return res;
        
        HashMap<String, Integer> map = new HashMap<>();//string -> count
        
        int[] tarf = new int[26];
        
        for(int i = 0; i < wcnt; i++){
            map.put(words[i], map.getOrDefault(words[i], 0) + 1); 
            
            for(char ch : words[i].toCharArray()){
                tarf[ch - 'a']++;
            }
        }
        
        int[] freq = new int[26];
        int tarLen = wcnt * wlen;
        for(int i = 0; i < tarLen; i++){
            freq[s.charAt(i) - 'a']++;
        }
        
        if(isCandidate(freq, tarf)){
            if(isConcat(s, 0, tarLen - 1, wlen, map)){
                res.add(0);
            }
        }
        
        for(int i = tarLen; i < n; i++){
            freq[s.charAt(i) - 'a']++;
            freq[s.charAt(i - tarLen) - 'a']--;
            
            if(isCandidate(freq, tarf)){
                if(isConcat(s, i - tarLen + 1, i, wlen,  map)){
                    res.add(i - tarLen + 1);
                }
            }
        }
        
        
        return res;
    }
    
    
    private boolean isCandidate(int[] f1, int[] f2){
        for(int i = 0; i < 26; i++){
            if(f1[i] != f2[i])
                return false;
        }
        
        return true;
    }
    
    private boolean isConcat(String s, int start, int end, int wlen, HashMap<String, Integer> map){
        HashMap<String, Integer> map2 = new HashMap<>();
        
        for(int i = start; i <= end; i += wlen){
            String word = s.substring(i, i + wlen);
            
            if(!map.containsKey(word))
                return false;
            
            map2.put(word, map2.getOrDefault(word, 0) + 1);
            
            if(map2.get(word) > map.get(word))
                return false;
        }
        
        /*System.out.println(start);
        for(Map.Entry<String, Integer> entry : map2.entrySet()){
            System.out.println(entry.getKey()+ "->" + entry.getValue());
        }*/
        
        return true;
    }
}
