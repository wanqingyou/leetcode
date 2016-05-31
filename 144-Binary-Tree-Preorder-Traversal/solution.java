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
    public List<Integer> preorderTraversal(TreeNode root) {
       preOrder(root);
       return result;
    }
    private void preOrder(TreeNode root){
        if(root==null) return;
        result.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}