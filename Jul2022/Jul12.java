/*
473. Matchsticks to Square
Medium

You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

Return true if you can make this square and false otherwise.

Example 1:

Input: matchsticks = [1,1,2,2,2]
Output: true
Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
Example 2:

Input: matchsticks = [3,3,3,3,4]
Output: false
Explanation: You cannot find a way to form a square with all the matchsticks.

Constraints:

1 <= matchsticks.length <= 15
1 <= matchsticks[i] <= 108
*/
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0, n = matchsticks.length;
        
        for(int i = 0; i < n; i++)
            sum += matchsticks[i];
        if(sum % 4 != 0)//not dividable into 4 equal halves
            return false;
        
        int tar = sum / 4;//target side
        
        Arrays.sort(matchsticks);
        int[] sides = new int[4];
        boolean[] used = new boolean[n];
        
        return divide(matchsticks, sides, 0, 0, used, tar);
    }
    
    public boolean divide(int[] matchsticks, int[] sides, int index, int start, boolean[] used, int tar){
        if(index == 3){// 3 sides of tar -> then 4th is also possible
           return true;
        }
        
        if(sides[index] == tar){//go for next side
            return divide(matchsticks, sides, index + 1, 0, used, tar);
        }
        
        //choose matchstick for this sies
        for(int i = start; i < matchsticks.length; i++){
            if(used[i] || (i > 0 && matchsticks[i] == matchsticks[i - 1] && !used[i - 1]))//if prev is same & it does not give answer -> then this element call same recursion -> avoid it
                continue;
            if(sides[index] + matchsticks[i] > tar)
                continue;
            
            sides[index] += matchsticks[i];
            used[i] = true;
            if(divide(matchsticks, sides, index, i + 1, used, tar))
                return true;
            
            //backtrack
            used[i] = false;
            sides[index] -= matchsticks[i];
        }
        
        return false;
    }
}
