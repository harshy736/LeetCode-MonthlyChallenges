/*
1041. Robot Bounded In Circle

On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:

"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degrees to the right.
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

 

Example 1:

Input: instructions = "GGLLGG"
Output: true
Explanation: The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
Example 2:

Input: instructions = "GG"
Output: false
Explanation: The robot moves north indefinitely.
Example 3:

Input: instructions = "GL"
Output: true
Explanation: The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
 

Constraints:

1 <= instructions.length <= 100
instructions[i] is 'G', 'L' or, 'R'.

*/
class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        //dir - north, west, south , east
        
        int d = 0;//in starting facing towards north
        int x = 0, y = 0;//starting position
        
        //straight pass
        for(char ch : instructions.toCharArray()){
            if(ch == 'G'){
                x += dir[d][0];
                y += dir[d][1];
            }else if(ch == 'L'){//left change in direction
                d = (d + 1) % 4;
            }else{//ch === 'R' right
                d = (d + 3) % 4;//(d - 1 + 4) % 4
            }
        }
        
        if(d != 0)//not facing north
            return true;
        else if(x == 0 && y == 0)//comes to origin
            return true;
        
        return false;
    }
}
