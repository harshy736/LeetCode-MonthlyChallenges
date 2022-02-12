/*
127. Word Ladder
Hard
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
*/

class Solution {//By using Bidirectional BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<String>(wordList);
        if(!wordSet.contains(endWord))
            return 0;//endWord doesn't exists
        
        Set<String> forwardSet = new HashSet<>();
        Set<String> backwardSet = new HashSet<>();
        forwardSet.add(beginWord);
        backwardSet.add(endWord);
        
        //remove words from wordSet which makes searching more effevtive
        //also works as visited array
        wordSet.remove(beginWord);
        wordSet.remove(endWord);
        
        return transform(forwardSet, backwardSet, wordSet);
    }

    public int transform(Set<String> forwardSet, Set<String> backwardSet, Set<String> wordSet) {
        Set<String> newSet = new HashSet<>();
        
        for(String fstr : forwardSet){
            char[] word = fstr.toCharArray();//char array
            
            for(int i = 0; i < word.length; i++){//for every char
                char realC = word[i];
                for(char ch = 'a' ; ch <= 'z'; ch++){//every possible char
                    word[i] = ch;//replacing
                    String target = String.valueOf(word);
                    
                    if(backwardSet.contains(target))
                        return 2;//1st word in forward & 2nd in backeard
                    else if(wordSet.contains(target) && !forwardSet.contains(target)){
                        newSet.add(target);
                        wordSet.remove(target);//marked as visited
                    }
                }
                word[i] = realC;//putting original char
            }
            
        }
        
        if(newSet.size() == 0)//can not move further
            return 0;
        
        forwardSet = newSet;
        
        //always pass first set as smaller set
        //Bcz we iterate on 1st set and if it is samller time complexity decreases
        int count = (forwardSet.size() > backwardSet.size()) ? transform(backwardSet, forwardSet, wordSet) : transform(forwardSet, backwardSet, wordSet);
        
        return count == 0 ? 0 : count + 1;
    }
}
