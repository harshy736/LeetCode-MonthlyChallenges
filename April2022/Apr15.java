/*
669. Trim a Binary Search Tree
Medium

Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that all its elements lies in [low, high]. Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.

Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.

Example 1:

Input: root = [1,0,2], low = 1, high = 2
Output: [1,null,2]
Example 2:

Input: root = [3,0,4,null,2,null,null,1], low = 1, high = 3
Output: [3,2,null,1]
 
Constraints:

The number of nodes in the tree in the range [1, 104].
0 <= Node.val <= 104
The value of each node in the tree is unique.
root is guaranteed to be a valid binary search tree.
0 <= low <= high <= 104
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        //using recurdion
        if(root == null)return null;
        
        if(root.val < low)//below the range -> left subtree also below he range
            return trimBST(root.right, low, high);//right subtree may be in range
        
        if(root.val > high)//above the range -> right subtree also above the range
            return trimBST(root.left, low, high);//only possibilty is updated left subtree is in range
        
        //if root is in range
        
        root.left = trimBST(root.left, low, high);//get correct left subtree
        root.right = trimBST(root.right, low, high);//get correct right subtree
        
        return root;
    }
}
