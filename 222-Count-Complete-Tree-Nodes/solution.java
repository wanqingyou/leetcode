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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        return numOfNode(root);
        
    }
    private int numOfNode(TreeNode root){
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return 1;
        return numOfNode(root.left)+numOfNode(root.right)+1;
    }
}