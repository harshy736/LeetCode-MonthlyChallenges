/*
987. Vertical Order Traversal of a Binary Tree
Hard

4998

3917

Add to List

Share
Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.
Example 2:


Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
          1 is at the top, so it comes first.
          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.
Example 3:


Input: root = [1,2,3,4,6,5,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
This case is the exact same as example 2, but with nodes 5 and 6 swapped.
Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 1000
*/

class Pair{
    TreeNode node;
    int hd;
    
    Pair(TreeNode node, int hd){
        this.node = node;
        this.hd = hd;
    }
}

class Solution {
    class SortBy implements Comparator<int[]>{
        public int compare(int[] e1, int[] e2){
           if(e1[1] == e2[1])
               return e1[0] - e2[0];
            
            return e1[1] - e2[1];
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> q = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null)
            return res;
        
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        
        q.add(new Pair(root, 0));
        int level = 0;
        int min = 0, max = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- > 0){
                Pair rem = q.remove();
                
                min = Math.min(min, rem.hd);
                max = Math.max(max, rem.hd);
                
                if(!map.containsKey(rem.hd))
                    map.put(rem.hd, new ArrayList<>());
                
                map.get(rem.hd).add(new int[]{rem.node.val, level});
                
                if(rem.node.left != null){
                    q.add(new Pair(rem.node.left, rem.hd - 1));
                }
                
                if(rem.node.right != null){
                    q.add(new Pair(rem.node.right, rem.hd + 1));
                }
            }
            
            level++;
        }
        
        for(int i = min; i <= max; i++){
            Collections.sort(map.get(i), new SortBy());
        
            List<Integer> list = new ArrayList<>();
            for(int[] arr : map.get(i))
                list.add(arr[0]);
            
            res.add(list);
        }
        
        return res;
    }
}
