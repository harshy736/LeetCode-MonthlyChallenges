/*
844. Backspace String Compare
Easy

Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
Example 3:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
 
Constraints:

1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.
 
Follow up: Can you solve it in O(n) time and O(1) space?
*/
class Solution {
    public boolean backspaceCompare(String s, String t) {//Using Pointer
        int sp = s.length() - 1, tp = t.length() - 1;
        
        while(sp >= 0 || tp >= 0){
            sp = nextChar(s, sp);
            tp = nextChar(t, tp);
            
            if((sp < 0 && tp >= 0) || (tp < 0 && sp >= 0) || ((sp >= 0 && tp >= 0) && s.charAt(sp) != t.charAt(tp))){
                return false;
            }
            
            //System.out.println(s.charAt(sp) + " " + t.charAt(tp));
            
            sp--;
            tp--;
        }
        
        return true;
    }
    
    private int nextChar(String str, int pos){
        if(pos < 0)return pos;
        
        char ch = str.charAt(pos);
        int jump = ch == '#' ? 2 : 0;
        
        while(jump > 0){
            pos--;
            jump--;
            
            if(pos < 0)
                break;
            
            ch = str.charAt(pos);
            if(ch == '#')
                jump += 2;
        }
        
        return pos;
    }
}
