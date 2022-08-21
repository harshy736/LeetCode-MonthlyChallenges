/*
936. Stamping The Sequence
Hard

1171

188

Add to List

Share
You are given two strings stamp and target. Initially, there is a string s of length target.length with all s[i] == '?'.

In one turn, you can place stamp over s and replace every letter in the s with the corresponding letter from stamp.

For example, if stamp = "abc" and target = "abcba", then s is "?????" initially. In one turn you can:
place stamp at index 0 of s to obtain "abc??",
place stamp at index 1 of s to obtain "?abc?", or
place stamp at index 2 of s to obtain "??abc".
Note that stamp must be fully contained in the boundaries of s in order to stamp (i.e., you cannot place stamp at index 3 of s).
We want to convert s to target using at most 10 * target.length turns.

Return an array of the index of the left-most letter being stamped at each turn. If we cannot obtain target from s within 10 * target.length turns, return an empty array.

 

Example 1:

Input: stamp = "abc", target = "ababc"
Output: [0,2]
Explanation: Initially s = "?????".
- Place stamp at index 0 to get "abc??".
- Place stamp at index 2 to get "ababc".
[1,0,2] would also be accepted as an answer, as well as some other answers.
Example 2:

Input: stamp = "abca", target = "aabcaca"
Output: [3,0,1]
Explanation: Initially s = "???????".
- Place stamp at index 3 to get "???abca".
- Place stamp at index 0 to get "abcabca".
- Place stamp at index 1 to get "aabcaca".
 

Constraints:

1 <= stamp.length <= target.length <= 1000
stamp and target consist of lowercase English letters.
*/
class Solution {
    public int[] movesToStamp(String stamp, String target) {//NOT
        //think in reverseOrder
        //try to convert target string into empty string
        //and store the operations index
        
        //if not possible -> return []
        
        //last stamp has identaical with s -> search for stamp in target -> if found then thi sis last stamp
        //move for next stamp
        
        
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        
        int tlen = t.length, slen = s.length;
        int count = 0;//number of ? 
        boolean[] visited = new boolean[tlen];//vis[i] -> tells if this index is used as a starting index of stamp or not
        
        List<Integer> list = new ArrayList<>();
        
        while(count != tlen){
            boolean stampFind = false;
            
            for(int i = 0; i <= tlen - slen; i++){
                if(!visited[i] && isStamp(t, i, s)){
                    visited[i] = true;
                    count += replace(t, i, slen);
                    stampFind = true;
                    
                    list.add(i);
                }
            }
            
            if(!stampFind){//no stamp found -> not possible to convert
                return new int[0];
            }
        }
        
        int size = list.size();
        int k = 0;
        
        int[] res = new int[size];
        
        for(int i = size - 1; i >= 0; i--){
            res[k++] = list.get(i);
        }
        
        return res;
    }
    
    private boolean isStamp(char[] t, int pos, char[] s){
        int slen = s.length;
        
        for(int i = 0; i < slen; i++){
            if(t[i + pos] != '?' && t[i + pos] != s[i]){
                return false;
            }
        }
        
        return true;
    }
    
    private int replace(char[] t, int pos, int len){
        int count = 0;
        
        for(int i = pos; i < pos + len; i++){
            if(t[i] != '?'){
                count++;
                t[i] = '?';
            }
        }
        
        return count;
    }
}
