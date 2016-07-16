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
        int l=getLeft(root);
        int r=getRight(root);
        
        if(l==r) {  
            return (1<<l) - 1;  
        } else {  
            return countNodes(root.left)+countNodes(root.right)+1;
        }
        
    }
    private int numOfNode(TreeNode root){
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return 1;
        return numOfNode(root.left)+numOfNode(root.right)+1;
    }
    private int getLeft(TreeNode root){
        int count=0;
        while(root!=null){
            count++;
            root=root.left;
        }
        return count;
    }
    
    private int getRight(TreeNode root){
        int count=0;
        while(root!=null){
            count++;
            root=root.right;
        }
        return count;
    }
}