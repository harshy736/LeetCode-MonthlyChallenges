/*
451. Sort Characters By Frequency
Medium

Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 
Constraints:

1 <= s.length <= 5 * 105
s consists of uppercase and lowercase English letters and digits.
*/

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int size = map.size();
        
        Pair[] arr = new Pair[size];
        int i = 0;
        for(char ch : map.keySet()){
            arr[i++] = new Pair(ch, map.get(ch));
        }
        
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        for(i = 0; i < size; i++){
            int count = arr[i].count;
            
            while(count-- > 0)
                sb.append(arr[i].ch);
        }
        
        
        return sb.toString();
    }
    
    class Pair implements Comparable<Pair> {
        int count;
        char ch;
        
        Pair(char ch, int count){
            this.ch = ch;
            this.count = count;
        }
        
        //@Override
        public int compareTo(Pair o) {
            return o.count - this.count;
        }
    }
}
