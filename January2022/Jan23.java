/*
1291. Sequential Digits
An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

 

Example 1:

Input: low = 100, high = 300
Output: [123,234]
Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]
 

Constraints:

10 <= low <= high <= 10^9
*/
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1; i <= 9; i++){
            digits(low, high, 0, i, list);
        }
        
        Collections.sort(list);
        
        return list;
    }
    
    private void digits(int low, int high, int ans, int n, List<Integer> mr) {
		
		if(ans > high) {
			return;
		}
		if(ans >= low) {
			mr.add(ans);
		}
		if(n > 9) {
			return;
		}
		digits(low, high, ans * 10 + n, n + 1, mr);
    }
}
