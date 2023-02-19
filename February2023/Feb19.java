/*
103. Binary Tree Zigzag Level Order Traversal
Medium
8.7K
230
Companies
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //simple level order traversal
        //reverse filling if level is odd
        //Now using DFS
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)return ans;
        
        dfs(ans, root, 0);
        return ans;
    }
    
    private void dfs(List<List<Integer>> ans, TreeNode root, int level){
        if(root == null)return;
        
        if(level >= ans.size()){
            ans.add(new ArrayList<>());
        }
        
        if(level % 2 == 0)//even level
            ans.get(level).add(root.val);
        else//odd level
            ans.get(level).add(0, root.val);
        
        dfs(ans, root.left, level + 1);//left child
        dfs(ans, root.right, level + 1);//right child
    }
}
