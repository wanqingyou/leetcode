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
    public boolean isSymmetric1(TreeNode root) {
        if(root==null) return true;
        return isSym(root.left,root.right);
    }
    
    private boolean isSym(TreeNode left, TreeNode right){
        if(left == null)  
            return right ==null;  
        if(right == null)  
            return left == null;  
        if(left.val != right.val)  
            return false;  
        if(!isSym(left.left, right.right))  
            return false;  
        if(!isSym(left.right, right.left))  
            return false;  
      return true;  
    }
    
    //interative
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        LinkedList<TreeNode> lq=new LinkedList<TreeNode>();
        LinkedList<TreeNode> rq=new LinkedList<TreeNode>();
        lq.add(root.left);
        rq.add(root.right);
        while(!lq.isEmpty()&&!rq.isEmpty()){
            TreeNode left=lq.pollFirst();
            TreeNode right=rq.pollFirst();
            if(left==null&&right==null) continue;
            if(left==null&&right!=null) return false;
            if(left!=null&&right==null) return false;
            if(left.val != right.val)  
                return false;
            lq.add(left.left);
            lq.add(left.right);
            rq.add(right.right);
            rq.add(right.left);
        }
        return true;
    }
}