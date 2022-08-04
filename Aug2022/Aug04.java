/*
858. Mirror Reflection
Medium

589

1290

Add to List

Share
There is a special square room with mirrors on each of the four walls. Except for the southwest corner, there are receptors on each of the remaining corners, numbered 0, 1, and 2.

The square room has walls of length p and a laser ray from the southwest corner first meets the east wall at a distance q from the 0th receptor.

Given the two integers p and q, return the number of the receptor that the ray meets first.

The test cases are guaranteed so that the ray will meet a receptor eventually.

 

Example 1:


Input: p = 2, q = 1
Output: 2
Explanation: The ray meets receptor 2 the first time it gets reflected back to the left wall.
Example 2:

Input: p = 3, q = 1
Output: 1
 

Constraints:

1 <= q <= p <= 1000
*/
class Solution {
    public int mirrorReflection(int p, int q) {
        //explore by only 2 sides in consideration
        //if hit the bottom / top -> take extended sided mirror
        //meet at corner when p -> multiple of q
        
        //lcm of q , p -> length of mirror where ray ends at a corner
        int len = lcm(p, q);
        
        int mirrorUsed = len / p;
        int raysCount = len / q;
        
        //if raycount -> even -> ends on left side, else on right side
        //for extended part we use the mirror as flipped one
        //if(mirrorUsed -> even) then it is flipped pne
        
        int ans = -1;
        
        if(raysCount % 2 == 0){//left side
           ans = 2;
        }else{
            if(mirrorUsed % 2 == 1){
                ans = 1;
            }else{
                ans = 0;
            }
        }
        
        return ans;
    }
    
    private int lcm(int a, int b){
        int g = gcd(a, b);
        
        int l = (a * b) / g;
        return l;
    }
    
    private int gcd(int a, int b){
        if(b == 0)
            return a;
        
        return gcd(b, a % b);
    }
}
