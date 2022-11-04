/*
345. Reverse Vowels of a String
Easy

Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
*/

class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
       
        char[] arr = s.toCharArray();
        int start = 0, end = arr.length - 1;
        while(start < end){
            //bith are vowels -> swap
            if(vowels.contains(arr[start]) && vowels.contains(arr[end])){
                char tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
                start++;
                end--;
            }
            
            if(!vowels.contains(arr[start]))//consonant
                start++;
            if(!vowels.contains(arr[end]))//consonant
                end--;
        }
        
        return String.valueOf(arr);
    }
}
