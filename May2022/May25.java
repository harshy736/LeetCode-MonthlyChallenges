/*
354. Russian Doll Envelopes
Hard

You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.

One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

Note: You cannot rotate an envelope.

Example 1:

Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
Example 2:

Input: envelopes = [[1,1],[1,1],[1,1]]
Output: 1
 
Constraints:

1 <= envelopes.length <= 105
envelopes[i].length == 2
1 <= wi, hi <= 105
*/
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        
        //sort by width in ascending and if weight is same then descending by height
        Arrays.sort(envelopes, new Comparator<int[]>(){
           @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0])
                    return b[1] - a[1];//des -> height
                
                return a[0] - b[0];//inc -> width
            }
        });
        
        //decsending height handles that no enevlope is added more than once
        //bcz first env of ant width is comes first
        //can not add into res
        //only changes previous heights for getting LIS
        
        List<Integer> res = new ArrayList<>();
        //lIS of heights
        
        for(int i = 1; i < n; i++){
            int pos = find(res, envelopes[i][1]);

            if(pos == res.size()){
                res.add(envelopes[i][1]);
            }else{
                res.set(pos, envelopes[i][1]);//replace
            }
        }
        
        return res.size();
    }
    
    private int find(List<Integer> res, int val){
        int s = 0, e = res.size() - 1;
        //int idx = 0;
        
        while(s <= e){
            int mid = s + (e - s) / 2;
            
            if(res.get(mid) == val)
                return mid;
            else if(res.get(mid) > val){
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        
        return s;
    }
}
