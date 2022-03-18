/*
316. Remove Duplicate Letters
Medium
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.
*/
class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        
        for(int i = 0; i < len; i++){
            map.put(s.charAt(i), i);//last position of every char   
        }
        
        Stack<Character> st = new Stack<>();
        boolean[] added = new boolean[26];
        
        for(int i = 0; i < len; i++){
            char ch = s.charAt(i);
            if(added[ch - 'a'])//added already
                continue;
            
            //find its perfect position
            //By removing all larger characters
            while(!st.isEmpty() && ch < st.peek() && i < map.get(st.peek())){
                added[st.pop() - 'a'] = false;
            }
            
            st.push(ch);
            added[ch - 'a'] = true;
        }
        
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty())
            ans.append(st.pop());
        
        return String.valueOf(ans.reverse());
    }
}
