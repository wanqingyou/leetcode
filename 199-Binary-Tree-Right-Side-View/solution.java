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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();  
        if (root == null) return ans;  
          
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();  
        queue.add(root);  
        queue.add(null);
        
        while(!queue.isEmpty()){
            TreeNode p=queue.pollFirst();
            
            if(p==null){
                if(queue.isEmpty()){
                    break;
                }else{
                    queue.add(null);//another level
                }
            }else{
                if(queue.peek()==null){//the most right node
                    ans.add(p.val);
                }
                if(p.left!=null){
                    queue.add(p.left);
                }
                if(p.right!=null){
                    queue.add(p.right);
                }
            }
        }
        return ans;
    }
}