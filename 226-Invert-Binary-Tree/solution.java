/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        
        TreeNode p=root;
        TreeNode left=invertTree(p.left);
        TreeNode right=invertTree(p.right);
        p.left=right;
        p.right=left;
        
        return root;
        
    }
}