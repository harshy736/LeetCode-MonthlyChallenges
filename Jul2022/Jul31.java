/*
307. Range Sum Query - Mutable
Medium

Given an integer array nums, handle multiple queries of the following types:

Update the value of an element in nums.
Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
void update(int index, int val) Updates the value of nums[index] to be val.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 
Example 1:

Input
["NumArray", "sumRange", "update", "sumRange"]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
Output
[null, 9, null, 8]

Explanation
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
numArray.update(1, 2);   // nums = [1, 2, 5]
numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8

Constraints:

1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
0 <= index < nums.length
-100 <= val <= 100
0 <= left <= right < nums.length
At most 3 * 104 calls will be made to update and sumRange.
*/
class NumArray {
    //Segment tree
    int[] tree;
    int[] arr;
    int n;
    
    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[4 * n];
        this.arr = nums;
        
        build(1, 0, n - 1);
    }
    
    //builds the segment tree
    public int build(int node, int start, int end){
        if(start == end){//leaf node
            tree[node] = arr[start];
        }else{
            int mid = (start + end) / 2;
            
            int left = build(node * 2, start, mid);
            int right = build(node * 2 + 1, mid + 1, end);
            tree[node] = left + right;
        }
        
        return tree[node];
    }
    
    
    //implementer
    private int update(int node, int start, int end, int index, int val){
        if(start > index || end < index)
            return tree[node];
        
        if(start == end){
            tree[node] = val;
            arr[index] = val;
        }else{
            int mid = (start + end) / 2;
            
            int left = update(node * 2, start, mid, index, val);
            int right = update(node * 2 + 1, mid + 1, end, index, val);
            tree[node] = left + right;
        }
        
        return tree[node];
    }
    
    public void update(int index, int val) {
        update(1, 0, n - 1, index, val);    
    }
    
    public int sumRange(int left, int right) {
        return sumRange(1, 0, n - 1, left, right);
    }
    
    //implemet
    private int sumRange(int node, int start, int end, int l, int r){
         if(start > r || end < l)//outside
            return 0;
        
        if(start == end)
            return tree[node];
        else if(l <= start && r >= end)//inside
            return tree[node];
        else{//partial
            int mid = (start + end) / 2;
            
            int left = sumRange(node * 2, start, mid, l, r);
            int right = sumRange(node * 2 + 1, mid + 1, end, l, r);
            
            return left + right;
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
