/*
class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] dp = new int[n];
        //dp[i] -> distance from closest person
        
        int[] lc = new int[n];//left closest persom
        int[] rc = new int[n];//right closest person
        
        //fill lc
        if(seats[0] == 1)
            lc[0] = 0;
        else
            lc[0] = -1;
        
        for(int i = 1; i < n; i++){
            if(seats[i] == 1)
                lc[i] = i;
            else
                lc[i] = lc[i - 1];
        }
        
         //fill rc
        if(seats[n - 1] == 1)
            rc[n - 1] = n - 1;
        else
            rc[n - 1] = -1;
        
        for(int i = n - 2; i >= 0; i--){
            if(seats[i] == 1)
                rc[i] = i;
            else
                rc[i] = rc[i + 1];
        }
        
        int maxD = 0;
        for(int i = 0; i < n; i++){
            if(lc[i] == -1)
                dp[i] = rc[i] - i;
            else if(rc[i] == -1)
                dp[i] = i - lc[i];
            else
                dp[i] = Math.min(i - lc[i], rc[i] - i);
            
            if(dp[i] > maxD)
                maxD = dp[i];
        }
        
        return maxD;
    }
}
*/
