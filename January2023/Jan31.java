/*
1626. Best Team With No Conflicts
Medium
You are the manager of a basketball team. For the upcoming tournament, you want to choose the team with the highest overall score. The score of the team is the sum of scores of all the players in the team.

However, the basketball team is not allowed to have conflicts. A conflict exists if a younger player has a strictly higher score than an older player. A conflict does not occur between players of the same age.

Given two lists, scores and ages, where each scores[i] and ages[i] represents the score and age of the ith player, respectively, return the highest overall score of all possible basketball teams.

Example 1:

Input: scores = [1,3,5,10,15], ages = [1,2,3,4,5]
Output: 34
Explanation: You can choose all the players.
Example 2:

Input: scores = [4,5,6,5], ages = [2,1,2,1]
Output: 16
Explanation: It is best to choose the last 3 players. Notice that you are allowed to choose multiple people of the same age.
Example 3:

Input: scores = [1,2,3,5], ages = [8,9,10,1]
Output: 6
Explanation: It is best to choose the first 3 players. 
 
Constraints:

1 <= scores.length, ages.length <= 1000
scores.length == ages.length
1 <= scores[i] <= 106
1 <= ages[i] <= 1000
*/
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;

        Player[] players = new Player[n];
        for(int i = 0; i < n; i++){
            players[i] = new Player(scores[i], ages[i]);
        }

        Arrays.sort(players);//sort by age

        int ans = 0;//max score
        int[] dp = new int[n];

        for(int i = 0; i < n; i++){
            int prev = 0;
            
            int limitScore = players[i].score;

            //ith have maximum score for younger players
            for(int j = 0; j < i; j++){
                if(players[j].score <= limitScore){//younger so score must be <= limit score
                    prev = Math.max(prev, dp[j]);//dp[j] -> stores maximum sum of team possible
                }
            }

            dp[i] = players[i].score + prev;

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    class Player implements Comparable<Player> {
        int score, age;

        Player(int score, int age){
            this.score = score;
            this.age = age;
        }

        public int compareTo(Player o){
            if(this.age == o.age){
                return this.score - o.score;//increasing in score
            }

            return this.age - o.age;
        }
    }
}
