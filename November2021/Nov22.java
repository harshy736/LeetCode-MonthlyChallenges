/*
450. Delete Node in a BST

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
 

Example 1:


Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

Example 2:

Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.
Example 3:

Input: root = [], key = 0
Output: []
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        
        TreeNode nroot = null;
        
        if(root.val == key){//delete root
            if(root.left == null)
                root = root.right;
            else if(root.right == null)
                root = root.left;       
            else{//both children exists
                TreeNode max = getMaxInLeft(root.left);//max in left can replace root
                root.val = max.val;
                root.left = deleteNode(root.left, max.val);//delete max nde to avoid cycle
            }
           
        }else if(key < root.val)
            root.left = deleteNode(root.left, key);
        else
            root.right = deleteNode(root.right, key);
        
        return root;
    }
    
    public TreeNode getMaxInLeft(TreeNode root){
        if(root == null || root.right == null)
            return root;
   
        while(root.right != null){
           root = root.right;
        }
        
        return root;
    }
   

}
