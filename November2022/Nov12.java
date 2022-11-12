/*
295. Find Median from Data Stream
Hard
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
 

Constraints:

-105 <= num <= 105
There will be at least one element in the data structure before calling findMedian.
At most 5 * 104 calls will be made to addNum and findMedian.
 

Follow up:

If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
*/

class MedianFinder {//NOT
    //we have to keep last in 1st half -> max of first half
    //and start elemnt of 2nd half -> to take the median
    //min & max -> so we use 2 PriorityQueue
    
    PriorityQueue<Integer> min, max;

    public MedianFinder() {
        min = new PriorityQueue<>();//stores 2nd half & peek givest start of it
        max = new PriorityQueue<>(Collections.reverseOrder());//stores 2nd half -> peek gives last of it
    }
    
    public void addNum(int num) {
        if(max.isEmpty() || max.peek() >= num){//if this num belongs to 1st half
            max.offer(num);
        }else{//belongs to 2n half
            min.offer(num);
        }
        
        //adjust the 2 halfs if they are becoming unequal
        if(max.size() - min.size() == 2){//1st half have 2 more elemnts -> shift 1 last elemnt to 2nd half
            min.add(max.poll());    
        }else if(min.size() - max.size() == 2){//reverse
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        if(min.size() == max.size()){//even
            double ans = ((double)max.peek() + min.peek()) / 2;
            return ans;
        }else if(max.size() > min.size()){
            return max.peek();
        }else{
            return min.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
