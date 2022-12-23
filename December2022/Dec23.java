/*
309. Best Time to Buy and Sell Stock with Cooldown
Medium
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:

Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
Example 2:

Input: prices = [1]
Output: 0

Constraints:

1 <= prices.length <= 5000
0 <= prices[i] <= 1000
*/

class Solution {
    public int maxProfit(int[] prices) {
        int bp = -prices[0], sp = 0, cp = 0;
        
        for(int i = 0; i < prices.length; i++){
            int nbp = cp - prices[i];
            int nsp = bp + prices[i];
            int ncp = sp;
            
            bp = Math.max(bp, nbp);
            sp = Math.max(sp, nsp);
            cp = Math.max(cp, ncp);
        }
        
        return sp;
    }
}
