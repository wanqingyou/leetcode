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
    private List<Integer> result=new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return result;
    }
    private void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        result.add(root.val);
        inOrder(root.right);
    }
}