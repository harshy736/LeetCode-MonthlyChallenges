/*
458. Poor Pigs
Hard
There are buckets buckets of liquid, where exactly one of the buckets is poisonous. To figure out which one is poisonous, you feed some number of (poor) pigs the liquid to see whether they will die or not. Unfortunately, you only have minutesToTest minutes to determine which bucket is poisonous.

You can feed the pigs according to these steps:

Choose some live pigs to feed.
For each pig, choose which buckets to feed it. The pig will consume all the chosen buckets simultaneously and will take no time.
Wait for minutesToDie minutes. You may not feed any other pigs during this time.
After minutesToDie minutes have passed, any pigs that have been fed the poisonous bucket will die, and all others will survive.
Repeat this process until you run out of time.
Given buckets, minutesToDie, and minutesToTest, return the minimum number of pigs needed to figure out which bucket is poisonous within the allotted time.

Example 1:

Input: buckets = 1000, minutesToDie = 15, minutesToTest = 60
Output: 5
Example 2:

Input: buckets = 4, minutesToDie = 15, minutesToTest = 15
Output: 2
Example 3:

Input: buckets = 4, minutesToDie = 15, minutesToTest = 30
Output: 2

Constraints:

1 <= buckets <= 1000
1 <= minutesToDie <= minutesToTest <= 100
*/
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {//help
        int T = minutesToTest / minutesToDie;//max test possible within given time
        //choose pig no based on tests
        //1 pig -> i can check T + 1 bucket in T tests
        //pig can check a bucket in 1 test , T in T tests, + 1 if he is still alive
        //i.e T + 1
        
        //if 2 pig
        //place buckets like 2d array
        //1 pig to find row & 1 to col
        //each bucket can pich for T + 1
        //i.e (T + 1) * (T + 1) -> (T + 1)^2
        
        //and more than 2D spaees for more pigs
        //poison bucket can be identified by pig no which alive or dies
        
        //for any buckets we have to check next (T + 1) ^ x
        
        int pig = 0;
        int limit = 1;
        
        while(limit < buckets){//need to add pig
            pig++;
            limit *= (T + 1);
        }
        
        return pig;
    }
}
