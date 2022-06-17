/*
968. Binary Tree Cameras
Hard

You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.

Return the minimum number of cameras needed to monitor all nodes of the tree.

Example 1:

Input: root = [0,0,null,0,0]
Output: 1
Explanation: One camera is enough to monitor all nodes if placed as shown.
Example 2:

Input: root = [0,0,null,0,null,0,null,null,0]
Output: 2
Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.
 
Constraints:

The number of nodes in the tree is in the range [1, 1000].
Node.val == 0
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
    int ans = 0;
    public int minCameraCover(TreeNode root) {
        int v = dfs(root);
        if(v == 2){
            ans++;
        }
        
        return ans;
    }
    //0 -> means its children has camera -> childern covers parent
    //1 -> means it childern has coverage no need to cover them -> parent
    //2 -> children needs camera to cover
    
    private int dfs(TreeNode root){
        if(root == null)
            return 1;
        
        if(root.left == null && root.right == null)
            return 2;//child node
        
        int lc = dfs(root.left);
        int rc = dfs(root.right);
        
        if(lc == 2 || rc == 2){
            ans++;
            return 0;
        }
        
        if(lc == 0 || rc == 0)
            return 1;
        
        return 2;
    }
}
