/*
763. Partition Labels
Medium
You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.

 Example 1:

Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
Example 2:

Input: s = "eccbbbbdec"
Output: [10]
 
Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
*/
class Solution {
    public List<Integer> partitionLabels(String s) {
        //BY merging interval
        int n = s.length();
        int[] last = new int[26];//end of every character
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            last[s.charAt(i) - 'a'] = i;//end
        }
        
        //partition
        int end = 0, start = 0;
        for(int i = 0; i < n; i++){
            int pos = s.charAt(i) - 'a';
            
            end = Math.max(end, last[pos]);//merge interval
            
            //complete one partition
            if(i == end){
                ans.add(end - start + 1);
                start = i + 1;//next interval
            }
        }
        
        return ans;
    }
}
