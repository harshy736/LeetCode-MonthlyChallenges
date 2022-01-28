/*
211. Design Add and Search Words Data Structure

Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 

Constraints:

1 <= word.length <= 500
word in addWord consists lower-case English letters.
word in search consist of  '.' or lower-case English letters.
At most 50000 calls will be made to addWord and search.
*/

class WordDictionary {
    class Trie{
        boolean isEnd;
        Trie[] children;
        
        Trie(){
            isEnd = false;
            children = new Trie[26];
        }
    }
    
    private Trie root;
   
    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        Trie node = root;
        for(char ch : word.toCharArray()){
            if(node.children[ch - 'a'] == null)
                node.children[ch - 'a'] = new Trie();
            
            node = node.children[ch - 'a'];
        }
        
        node.isEnd = true;//mark as end
    }
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
    
    public boolean searchHelper(String word, int idx, Trie node){
        if(idx == word.length()){
            return node.isEnd;
        }
        
        char ch = word.charAt(idx);
        if(ch == '.'){
            for(int i = 0; i < 26; i++){
                if(node.children[i] != null && searchHelper(word, idx + 1, node.children[i]))
                    return true;
            }
            
            return false;
        }else{
            if(node.children[ch - 'a'] == null)
                return false;
            
            return searchHelper(word, idx + 1, node.children[ch - 'a']);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
