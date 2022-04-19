/*
99. Recover Binary Search Tree
Medium

You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

Example 1:

Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
Example 2:

Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 
Constraints:

The number of nodes in the tree is in the range [2, 1000].
-231 <= Node.val <= 231 - 1
 
Follow up: A solution using O(n) space is pretty straight-forward. Could you devise a constant O(1) space solution?
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
    public void recoverTree(TreeNode root) {
        //inorder of BST -> sorted
        //if swapping is done -. then sorted pattern doesn't exists
        //atleast one pair is in reversed order
        
        //normal -> 1,2,3,4,5.6
        //swapped -> 1,6,3,4,2,5   --> 3 & 6 are wrong placed -> 2 paires are in wrong order
        
        //Or -> 1,3,2,4,5,6 -> 2 & 3 are wrong placed -> consecutive nodes are wrong placed
        //single pair wrong
        
        //inorder by Morris Traversal
        //Algorithm to in order any tree
        inorder(root);
    }
    
    private void inorder(TreeNode root){
        if(root == null)
            return;
        
        TreeNode a = null, b = null , prev = null, curr = root;
        
        //morris order
        while(curr != null){//until whole tree is not completed
            TreeNode leftNode = curr.left;
            
            if(leftNode == null){//no need of thread
                //curr is in its inorder position
                if(prev != null && prev.val > curr.val){
                    if(a == null)
                        a = prev;
                    b = curr;
                }
                
                //move
                prev = curr;
                curr = curr.right;
            }else{//left subtree exists need to traverse left subtree first to get inorder at curr
                TreeNode rmn = greatestNode(curr.left, curr);//right most node in left tree
                //to connect with root  -> link
                
                if(rmn.right == null){//left subtree not visited -> go on left subtree
                    rmn.right = curr;//thread to get back to curr after traversal of left subtree
                    curr = curr.left;
                }else{//left subtree completed -> now inorder f curr
                    rmn.right = null;//remove thread
                    
                    if(prev.val > curr.val){
                        if(a == null)//if it is first wrong pair
                            a = prev;

                        b = curr;
                    }
                    
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        
        //swap nodes
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
    
    private TreeNode greatestNode(TreeNode node, TreeNode curr){
        while(node.right != null && node.right != curr)
            node = node.right;
        
        return node;
    }
}
