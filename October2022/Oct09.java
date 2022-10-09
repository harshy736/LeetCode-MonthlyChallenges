/*
653. Two Sum IV - Input is a BST
Easy

Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input: root = [5,3,6,2,4,null,7], k = 9
Output: true
Example 2:

Input: root = [5,3,6,2,4,null,7], k = 28
Output: false

Constraints:

The number of nodes in the tree is in the range [1, 104].
-104 <= Node.val <= 104
root is guaranteed to be a valid binary search tree.
-105 <= k <= 105
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
    public boolean findTarget(TreeNode root, int k) {
        //check every element -> and find its complimentary part
        //if find return true
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode node = q.remove();
            
            int tar = k - node.val;
            
            if(tar != node.val && find(root, tar))
                return true;
            
            if(node.left != null)
                q.add(node.left);
            
            if(node.right != null)
                q.add(node.right);
        }
        
        return false;
    }
    
    private boolean find(TreeNode root, int tar){
        if(root == null)
            return false;
        else if(root.val == tar)
            return true;
        else if(root.val > tar)
            return find(root.left, tar);
        else
            return find(root.right, tar);
    }
}

