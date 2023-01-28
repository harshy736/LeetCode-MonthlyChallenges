/*
352. Data Stream as Disjoint Intervals
Hard
Given a data stream input of non-negative integers a1, a2, ..., an, summarize the numbers seen so far as a list of disjoint intervals.

Implement the SummaryRanges class:

SummaryRanges() Initializes the object with an empty stream.
void addNum(int value) Adds the integer value to the stream.
int[][] getIntervals() Returns a summary of the integers in the stream currently as a list of disjoint intervals [starti, endi]. The answer should be sorted by starti.
 
Example 1:

Input
["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
[[], [1], [], [3], [], [7], [], [2], [], [6], []]
Output
[null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]

Explanation
SummaryRanges summaryRanges = new SummaryRanges();
summaryRanges.addNum(1);      // arr = [1]
summaryRanges.getIntervals(); // return [[1, 1]]
summaryRanges.addNum(3);      // arr = [1, 3]
summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
summaryRanges.addNum(7);      // arr = [1, 3, 7]
summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
 
Constraints:

0 <= value <= 104
At most 3 * 104 calls will be made to addNum and getIntervals.
 

Follow up: What if there are lots of merges and the number of disjoint intervals is small compared to the size of the data stream?
*/

class SummaryRanges {
    TreeMap<Integer, int[]> map;
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int val) {
        int start = val;
        
        if(map.floorKey(val) == null){
            map.put(val, new int[]{val, val});
        }else{
            int[] prev = map.get(map.floorKey(val));
            
            if(val <= prev[1])
                return;
            
            if(val == prev[1] + 1){
                start = prev[0];
                prev[1] = val;
                
                map.put(prev[0], prev);
            }else{
                map.put(val, new int[]{val, val});
            }
        }
        
        if(map.containsKey(val + 1)){
            int[] next = map.get(val + 1);
            int[] prev = map.get(start);
            
            map.remove(val + 1);
            prev[1] = next[1];
            map.put(start, prev);
        }
    }
    
    public int[][] getIntervals() {
        int size = map.size();
        
        int[][] ans = new int[size][];
        
        int idx = 0;
        for(int key : map.keySet()){
            ans[idx++] = map.get(key);
        }
        
        return ans;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
