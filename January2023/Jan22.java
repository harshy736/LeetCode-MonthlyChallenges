/*
131. Palindrome Partitioning
Medium
9.9K
320
Companies
Given a string s, partition s such that every 
substring
 of the partition is a 
palindrome
. Return all possible palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
*/

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        
        helper(s, 0, new ArrayList<>(), ans);
        return ans;
    }
    
    private void helper(String s, int idx, List<String> list, List<List<String>> ans){
        if(idx == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        int n = s.length();
        for(int j = idx; j < n; j++){
            if(isPallindrome(s, idx, j)){
                list.add(s.substring(idx, j + 1));
                helper(s, j + 1, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isPallindrome(String str, int s, int e){
        while(s < e){
            if(str.charAt(s) != str.charAt(e))
                return false;
            
            s++;
            e--;
        }
        
        return true;
    }
}
