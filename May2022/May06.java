/*
1209. Remove All Adjacent Duplicates in String II
Medium

You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"

Constraints:

1 <= s.length <= 105
2 <= k <= 104
s only contains lower case English letters.
*/
class Solution {
    public String removeDuplicates(String s, int k) {
        int[] dup = new int[s.length()];
        StringBuilder sb = new StringBuilder(s);
        int i = 1;
        dup[0] = 1;
        
        while(i < sb.length()){
            if(i == 0 || sb.charAt(i - 1) != sb.charAt(i))
                dup[i] = 1;
            else{
                dup[i] = dup[i - 1] + 1;
                
                if(dup[i] == k){
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                }
            }
            
            i++;
        }
        
        return sb.toString();
    }
    
}
