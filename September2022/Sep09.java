/*
1996. The Number of Weak Characters in the Game

You are playing a game that contains multiple characters, and each of the characters has two main properties: attack and defense. You are given a 2D integer array properties where properties[i] = [attacki, defensei] represents the properties of the ith character in the game.

A character is said to be weak if any other character has both attack and defense levels strictly greater than this character's attack and defense levels. More formally, a character i is said to be weak if there exists another character j where attackj > attacki and defensej > defensei.

Return the number of weak characters. 

Example 1:

Input: properties = [[5,5],[6,3],[3,6]]
Output: 0
Explanation: No character has strictly greater attack and defense than the other.
Example 2:

Input: properties = [[2,2],[3,3]]
Output: 1
Explanation: The first character is weak because the second character has a strictly greater attack and defense.
Example 3:

Input: properties = [[1,5],[10,4],[4,3]]
Output: 1
Explanation: The third character is weak because the second character has a strictly greater attack and defense.
 
Constraints:

2 <= properties.length <= 105
properties[i].length == 2
1 <= attacki, defensei <= 105
*/
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<>(){
           public int compare(int[] e1 , int[] e2){
               if(e1[0] == e2[0])
                   return e1[1] - e2[1];
               
               return e1[0] - e2[0];
           } 
        });
        
        int maxDef = 0;
        int n = properties.length;
        
        List<Integer> list = new ArrayList<>();
        int weak = 0;
        
        for(int i = n - 1; i >= 0; i--){
            
            if(maxDef > properties[i][1])
                weak++;
            
            if(i > 0 && properties[i][0] == properties[i - 1][0]){
                list.add(properties[i][1]);
            }else{
                maxDef = Math.max(maxDef, properties[i][1]);
                
                for(int def : list)
                    maxDef = Math.max(maxDef, def);
                list.clear();
            }
        }
        
        return weak;
    }
}
