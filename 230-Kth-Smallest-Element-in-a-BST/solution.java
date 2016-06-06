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
    public int kthSmallest(TreeNode root, int k) {
        inOrderTravesal(root);
        return result.get(k-1);
        
    }
    
    private void inOrderTravesal(TreeNode root){
        if(root==null) return;
        inOrderTravesal(root.left);
        result.add(root.val);
        inOrderTravesal(root.right);
    }
}