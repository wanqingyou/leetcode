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
    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return result;
    }
    private void postOrder(TreeNode root){
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        result.add(root.val);
    }
}