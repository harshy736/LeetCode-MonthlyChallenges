/*
989. Add to Array-Form of Integer
Easy
The array-form of an integer num is an array representing its digits in left to right order.

For example, for num = 1321, the array form is [1,3,2,1].
Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.

Example 1:

Input: num = [1,2,0,0], k = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234
Example 2:

Input: num = [2,7,4], k = 181
Output: [4,5,5]
Explanation: 274 + 181 = 455
Example 3:

Input: num = [2,1,5], k = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021
 
Constraints:

1 <= num.length <= 104
0 <= num[i] <= 9
num does not contain any leading zeros except for the zero itself.
1 <= k <= 104
*/

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> ans = new LinkedList<>();
        int n = num.length, c = 0;
        
        for(int i = n - 1; i >= 0; i--){
            int sum = num[i] + c + k % 10;//add digit
            c = sum / 10;//carry
            sum %= 10;//less than 10
            k /= 10;//remove last digit
            
            ans.addFirst(sum);
        }
        
        while(k > 0){
            int sum = c + k % 10;
            c = sum / 10;
            sum %= 10;
            k /= 10;
            
            ans.addFirst(sum);
        }
        
        if(c > 0){//carry exists
            ans.addFirst(c);
        }
        
        return ans;
    }
}
