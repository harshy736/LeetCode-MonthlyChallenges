/*
946. Validate Stack Sequences
Medium

Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.

Example 1:

Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4),
pop() -> 4,
push(5),
pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
Example 2:

Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
Explanation: 1 cannot be popped before 2.
 
Constraints:

1 <= pushed.length <= 1000
0 <= pushed[i] <= 1000
All the elements of pushed are unique.
popped.length == pushed.length
popped is a permutation of pushed.
*/
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        
        //simply push element until we find next popped element
        //at end we can not get our next popped element -> unvalid sequences
        int i = 0;//for pushed
        int j = 0;//for popped
        
        Stack<Integer> st = new Stack<>();
        
        //until we get all popped elements
        while(j < n){
            if(st.isEmpty()){
                st.push(pushed[i]);
                i++;
            }else if(st.peek() == popped[j]){//desired pop element
                st.pop();
                j++;
            }else{
                if(i == n)//on peek -> unmatched element placed -> no popping allowed
                    return false;
                
                st.push(pushed[i]);//push next element to get next popped element at top
                i++;
            }
        }
        
        return true;
    }
}
