/*
106. Construct Binary Tree from Inorder and Postorder Traversal

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]
 

Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
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
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        
    }
    
    public TreeNode build(int[] inorder, int inS, int inE, int[] postorder, int postS, int postE){
        if(inS > inE || postS > postE)//no node exist
            return null;
        
        TreeNode root = new TreeNode(postorder[postE]);
        //root is always last element of postarrray
        
        //Inorder -> left - root - right
        //PostOrder -> left + right + root
        
        int rootIndex= map.get(root.val);//index in inorder array
        //left of it -> all leftsubtree nodes
        //right of it -> all right subtree nodes
        
        root.left = build(inorder, inS, rootIndex - 1, postorder, postS, postS + rootIndex - inS - 1);
        //length of left nodes = rootIndex - inS - 1
        //postE -> postS + length of left nodes
        
        root.right = build(inorder, rootIndex + 1, inE, postorder, postS + rootIndex - inS, postE - 1);
        //postS -> postS + length of left nodes + 1
        
        return root;
    }
}
