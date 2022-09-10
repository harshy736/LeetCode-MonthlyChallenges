/*
188. Best Time to Buy and Sell Stock IV
Hard

5337

174

Add to List

Share
You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 

Constraints:

0 <= k <= 100
0 <= prices.length <= 1000
0 <= prices[i] <= 1000
*/
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n == 0 || k == 0)
            return 0;
        
        int[][] buy = new int[k + 1][n];//buy[i][j] -> stores maximum upto jth element when i is max transactions
        int[][] sell = new int[k + 1][n];
        
        for(int j = 0; j < n; j++){
            for(int i = 1; i <= k; i++){
                if(j == 0){
                    buy[i][j] = -prices[j];
                }else{
                    //compare with previous buy and if I but today
                    buy[i][j] = Math.max(buy[i][j - 1], sell[i - 1][j - 1] - prices[j]);
                    sell[i][j] = Math.max(sell[i][j - 1], buy[i][j] + prices[j]);
                }
            }
        }
        
        int ans = sell[k][n - 1];
        return ans;
    }
}
