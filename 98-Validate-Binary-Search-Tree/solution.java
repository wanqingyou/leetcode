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
    List<Integer> list=new ArrayList<Integer>();
    public boolean isValidBST(TreeNode root) {
        // if(root==null) return true;
        // if(root.left==null&&root.right==null) return true;
        // if((root.left!=null&&root.left.val>=root.val) || (root.right!=null&&root.right.val<=root.val)) return false;
        // else{
        //     return isValidBST(root.left)&&isValidBST(root.right);
        // }
        inOrder(root);
        for(int i=1;i<list.size();i++){
            if(list.get(i)<=list.get(i-1)){
                return false;
            }
        }
        return true;
    }
    
    private void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

}