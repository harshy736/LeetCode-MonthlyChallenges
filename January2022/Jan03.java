/*
997. Find the Town Judge

In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

 

Example 1:

Input: n = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: n = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: n = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
 

Constraints:

1 <= n <= 1000
0 <= trust.length <= 104
trust[i].length == 2
All the pairs of trust are unique.
ai != bi
1 <= ai, bi <= n
*/

class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n == 1)
            return 1;
        
        boolean[] judge = new boolean[n + 1];
        //here judge[i] -> whethet he can trust any body or not
        //true -> atleast trust another person
        int person = n;//no of persons who doesnlt trust anybody
        
        for(int i = 0; i < trust.length; i++){
            if(judge[trust[i][0]] == false){
                judge[trust[i][0]] = true;//trust somebody
                person--;
            }
        }
        
        if(person > 1)//prperty failure
            return -1;
        
        //there exist one person who doesn't trust anybody
        //check whether he is trusted by all the remaining person
        int pos = 0;
        for(int i = 1; i <= n; i++){
            if(judge[i] == false){
                pos = i;
                break;
            }
        }
        
        int tper = 0;//no of persond who trust pos
        for(int i = 0; i < trust.length; i++){
            if(trust[i][1] == pos){
                tper++;//increment
            }
        }
        
        if(tper != (n - 1))
            return -1;
        
        return pos;
    }
}
