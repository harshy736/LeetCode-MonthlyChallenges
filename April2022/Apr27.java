/*
1202. Smallest String With Swaps
Medium

2175

67

Add to List

Share
You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.

You can swap the characters at any pair of indices in the given pairs any number of times.

Return the lexicographically smallest string that s can be changed to after using the swaps.

 

Example 1:

Input: s = "dcab", pairs = [[0,3],[1,2]]
Output: "bacd"
Explaination: 
Swap s[0] and s[3], s = "bcad"
Swap s[1] and s[2], s = "bacd"
Example 2:

Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
Output: "abcd"
Explaination: 
Swap s[0] and s[3], s = "bcad"
Swap s[0] and s[2], s = "acbd"
Swap s[1] and s[2], s = "abcd"
Example 3:

Input: s = "cba", pairs = [[0,1],[1,2]]
Output: "abc"
Explaination: 
Swap s[0] and s[1], s = "bca"
Swap s[1] and s[2], s = "bac"
Swap s[0] and s[1], s = "abc"
 

Constraints:

1 <= s.length <= 10^5
0 <= pairs.length <= 10^5
0 <= pairs[i][0], pairs[i][1] < s.length
s only contains lower case English letters.
*/
class Solution {
    private class UnionFind {
        private int[] root;
        private int[] rank;

        // Initialize the array root and rank
        // Each vertex is representative of itself with rank 1
        UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        // Get the root of a vertex
        int find(int x) {
            if (x != root[x]) {
                root[x] = find(root[x]);
            }
            return root[x];
        }

        // Perform the union of two components
        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] >= rank[rootY]) {
                    root[rootY] = rootX;
                    rank[rootX] += rank[rootY];
                } else {
                    root[rootX] = rootY;
                    rank[rootY] += rank[rootX];
                }
            }
        }
    }
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());
        
        for (List<Integer> pair: pairs)
            uf.union(pair.get(0), pair.get(1));

        Map<Integer, List<Integer>> rootToComp = new HashMap<>();

        for (int v = 0; v < s.length(); v++){
            int root = uf.find(v);
            rootToComp.putIfAbsent(root, new ArrayList<>());
            rootToComp.get(root).add(v);
        }
        
        char[] smallestString = new char[s.length()];
        for (List<Integer> indices: rootToComp.values()){
            char[] characters = new char[indices.size()];
            int i = 0;
            for (int index: indices)
                characters[i++] = s.charAt(index);
            
            Arrays.sort(characters);
            
            for (int index = 0; index < indices.size(); index++){
                smallestString[indices.get(index)] = characters[index];
            }
        }
        
        return new String(smallestString);
    }
}
