/*
126. Word Ladder II

A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
Explanation: There are 2 shortest transformation sequences:
"hit" -> "hot" -> "dot" -> "dog" -> "cog"
"hit" -> "hot" -> "lot" -> "log" -> "cog"
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: []
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence 

Constraints:

1 <= beginWord.length <= 5
endWord.length == beginWord.length
1 <= wordList.length <= 500
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
*/
class Solution {//NOT
    
    ArrayList<ArrayList<Integer>> adj =  new ArrayList<>();
    List<List<Integer>> paths = new ArrayList<>();
    ArrayList<ArrayList<Integer>> parent = new ArrayList<>();
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int w = wordList.size();
        int i, j;
        
        for(i=0;i<w+1;i++){
            adj.add(new ArrayList<>());
        }
        
        for(i=0;i<w;i++){
            if(checkSingleDiff(beginWord, wordList.get(i)) == 1){
                addEdge(0, i+1);
            }
        }
        
        for(i=0;i<w;i++){
            for(j=i+1;j<w;j++){
                if(checkSingleDiff(wordList.get(i), wordList.get(j)) == 1){
                    addEdge(i+1, j+1);
                }
            }
        }
        
        // System.out.println("ADJ is");
        // for(i=0;i<adj.size();i++){
        //     System.out.print(i + " -> ");
        //     ArrayList<Integer> temp = adj.get(i);
        //     for(j=0;j<temp.size();j++){
        //         System.out.print(temp.get(j) + " ");
        //     }
        //     System.out.println();
        // }
        
        int beginWordInd = 0;
        int endWordInd = -1;
        for(i=0;i<w;i++){
            if(wordList.get(i).equals(endWord)){
                endWordInd = i+1;
                break;
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        if(endWordInd != -1){ 
            ans = getShortestSequences(beginWordInd, endWordInd, w+1, wordList, beginWord);
        }
        
        return ans;
    }
    
    private List<List<String>> getShortestSequences(int src, int dest, int vertices, List<String> wordList, String beginWord){
        ArrayList<Integer> path = new ArrayList<>();
        
        int i, j;
        for(i=0;i<vertices;i++){
            parent.add(new ArrayList<>());
        }
        
        BFS(vertices, src, wordList);
        
        getShortestSequencesUtil(path, vertices, dest);
        
        // System.out.println("Size of paths is " + paths.size());
        for(i=0;i<paths.size();i++){
            Collections.reverse(paths.get(i));
            paths.set(i, paths.get(i));
        }
        
        List<List<String>> ans = new ArrayList<>();
        
        for(i=0;i<paths.size();i++){
            List<Integer> p = paths.get(i);
            ArrayList<String> pp = new ArrayList<>();
            for(j=0;j<p.size();j++){
                if(p.get(j) == 0){
                    pp.add(beginWord);
                }
                else{
                    pp.add(wordList.get(p.get(j) - 1));   
                }
            }
            ans.add(pp);
        }
        
        return ans;
    }
    
    private void getShortestSequencesUtil(ArrayList<Integer> path, int vertices, int dest){
        if(dest == -1){
            paths.add(new ArrayList<>(path));
            return;
        }
        
        for(int p : parent.get(dest)){
            path.add(dest);
            getShortestSequencesUtil(path, vertices, p);
            path.remove(path.size() - 1);
        }
    }
    
    private void BFS(int vertices, int src, List<String> wordList){
        int shortestDist[] = new int[vertices];
        Arrays.fill(shortestDist, Integer.MAX_VALUE);
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        parent.get(src).clear();
        parent.get(src).add(-1);
        shortestDist[src] = 0;
        
        while(q.isEmpty() == false){
            int u = q.poll();
            for(int v : adj.get(u)){
                if(shortestDist[u] + 1 < shortestDist[v]){
                    shortestDist[v] = shortestDist[u] + 1;
                    q.offer(v);
                    parent.get(v).clear();
                    parent.get(v).add(u);
                }
                else if(shortestDist[u] + 1 == shortestDist[v]){
                    parent.get(v).add(u);
                }
            }
        }
        
        // System.out.println("Parent is ");
        // for(int i=0;i<parent.size();i++){
        //     ArrayList<Integer> p = parent.get(i);
        //     System.out.print(i + " -> ");
        //     for(int j=0;j<p.size();j++){
        //         System.out.print(p.get(j) + " ");    
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        
        // System.out.println("Shortest distance is ");
        // for(int i=0;i<shortestDist.length;i++){
        //     System.out.print(shortestDist[i] + " ");
        // }
        // System.out.println();
    }
    
    private void addEdge(int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    
    private int checkSingleDiff(String a, String b){
        int i;
        int count = 0;
        for(i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)){
                count++;
            }
        }
        
        return count;
    }
}
