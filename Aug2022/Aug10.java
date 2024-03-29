/*
108. Convert Sorted Array to Binary Search Tree
Easy

7379

387

Add to List

Share
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

 

Example 1:


Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:


Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in a strictly increasing order.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = helper(nums, 0, nums.length - 1);
        
        return root;
    }
    
    private TreeNode helper(int[] nums, int s, int e){
        if(s > e)
            return null;
        if(s == e){
            return new TreeNode(nums[s]);
        }
        
        int mid = s + (e - s) / 2;
        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, s, mid - 1);
        root.right = helper(nums, mid + 1, e);
        
        return root;
    }
}
