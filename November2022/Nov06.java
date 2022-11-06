/*
899. Orderly Queue
Hard
You are given a string s and an integer k. You can choose one of the first k letters of s and append it at the end of the string..

Return the lexicographically smallest string you could have after applying the mentioned step any number of moves.

Example 1:

Input: s = "cba", k = 1
Output: "acb"
Explanation: 
In the first move, we move the 1st character 'c' to the end, obtaining the string "bac".
In the second move, we move the 1st character 'b' to the end, obtaining the final result "acb".
Example 2:

Input: s = "baaca", k = 3
Output: "aaabc"
Explanation: 
In the first move, we move the 1st character 'b' to the end, obtaining the string "aacab".
In the second move, we move the 3rd character 'c' to the end, obtaining the final result "aaabc".
 

Constraints:

1 <= k <= s.length <= 1000
s consist of lowercase English letters.
*/

class Solution {
    public String orderlyQueue(String s, int k) {
        if(k == 1){
            StringBuilder sb = new StringBuilder(s);
            int len = s.length();
            
            String ans = s;
            for(int i = 0; i < len; i++){
                s = s.substring(1) + s.substring(0,1);
                
                if(s.compareTo(ans) < 0){//s is lexicographical smaller
                    ans = s;
                }
            }
            
            return ans;
        }else{//sorted string is answer 
            char[] arr = s.toCharArray();
            Arrays.sort(arr);

            return String.valueOf(arr);
        }
    }
}
