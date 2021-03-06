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
    // public List<String> binaryTreePaths(TreeNode root) {
    //     List<String> result=new ArrayList<String>();
    //     if(root==null)
    //         return result;
    //     if(root.left==null&&root.right==null){
    //         result.add(root.val+"");
    //         return result;
    //     }
    //     Stack<TreeNode> stack=new Stack<TreeNode>();
        
    //     TreeNode cur=root;
    //     stack.push(new TreeNode(-1));
    //     String str="";
    //     while(!stack.isEmpty()){
    //         while(cur.left!=null){
    //             str+=cur.val+"->";
    //             stack.push(cur);
    //             cur=cur.left;
    //         }
    //         str+=cur.val;
    //         if(cur.right==null){
    //             if(str!="")
    //                 result.add(str);
    //             str="";
    //             cur=stack.pop();
    //         }else{
    //             str+="->"+cur.right.val;
    //             cur=cur.right;
    //             stack.push(cur);
    //         }
    //     }
    //     return result;
    
    private List<String> result=new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root){
        if(root==null)
            return result;
        if(root.left==null&&root.right==null){
            result.add(root.val+"");
            return result;
        }
        
        checkBinaryTreePath("",root);
        return result;
    }
    
    private void checkBinaryTreePath(String path,TreeNode root){
        path+=root.val;
        
        if(root.left==null&&root.right==null){
            result.add(path);
        }
        if(root.left!=null){
            checkBinaryTreePath(path+"->",root.left);
        }
        if(root.right!=null){
            checkBinaryTreePath(path+"->",root.right);
        }
    }
}