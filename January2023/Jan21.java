/*
93. Restore IP Addresses
Medium
A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
 
Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
Example 2:

Input: s = "0000"
Output: ["0.0.0.0"]
Example 3:

Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 
Constraints:

1 <= s.length <= 20
s consists of digits only.
*/

class Solution {
    public List<String> restoreIpAddresses(String s) {
        //using recursion
        List<String> ans = new ArrayList<>();
        
        helper(s, 0, 0, new StringBuilder(""), ans);
        return ans;
    }
    
    private void helper(String s, int idx, int dots, StringBuilder ip, List<String> ans){
        if(dots == 4 && idx == s.length()){
            ans.add(ip.toString().substring(0, ip.length() - 1));
            return;
        }
        
        if(dots > 4 || idx == s.length())
            return;
        
        int len = ip.length();
        
        if(s.charAt(idx) == '0'){//only 1 case
            ip.append("0.");
            helper(s, idx + 1, dots + 1, ip, ans);
            ip.setLength(len);
            return;
        }
        
        int val = 0;
        for(int j = idx; j < s.length() && j < idx + 3; j++){
            val = val * 10 + (s.charAt(j) - '0');
            
            if(val <= 255){//valid tuple
                ip.append(s.substring(idx, j + 1) + ".");
                helper(s, j + 1, dots + 1, ip, ans);
                ip.setLength(len);//backtrack
            }
        }
    }
}
