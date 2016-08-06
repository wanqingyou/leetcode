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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        if(root==null){
            return result;
        }
        List<TreeNode> level=new ArrayList<TreeNode>();
        List<Integer> values=new LinkedList<Integer>();
        
        level.add(root);
        values.add(root.val);
        result.add(values);
        while(!level.isEmpty()){
            List<TreeNode> nextlevel=new ArrayList<TreeNode>();
            values=new LinkedList<Integer>();
            for(TreeNode tn:level){
                if(tn.left!=null){
                    nextlevel.add(tn.left);
                    values.add(tn.left.val);
                }
                if(tn.right!=null){
                    nextlevel.add(tn.right);
                    values.add(tn.right.val);
                }
            }
            if(!values.isEmpty())
                result.add(values);
            level=nextlevel;
        }
        Collections.reverse(result);
        return result;
    }
}