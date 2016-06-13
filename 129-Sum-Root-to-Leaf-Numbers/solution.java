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
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        TreeNode dummy=new TreeNode(-1);
        Stack<TreeNode> stack=new Stack<TreeNode>();
        List<String> paths=new ArrayList<String>();
        stack.push(dummy);
        stack.push(root);
        TreeNode p;
        String str="";
        while(!stack.isEmpty()&&stack.peek().val!=-1){
            p=stack.pop();
            while(p!=null){
                stack.push(p);
                str+=p.val;
                p=p.left;
            }
            p=stack.pop();
            if(p.right==null){
                paths.add(str);
                str=str.substring(0,str.length()-1);
                p=stack.pop();
            }else{
                p=p.right;
                stack.push(p);
                str+=p.val;
            }
        }
        int sum=0;
        
        for(String s:paths){
            sum+=Integer.parseInt(s);
        }
        return sum;
    }
}