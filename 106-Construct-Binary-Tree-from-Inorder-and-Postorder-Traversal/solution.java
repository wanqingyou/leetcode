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
    private Map<Integer,Integer> map=new HashMap<Integer,Integer>();//inorder element:position
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null||inorder.length==0||postorder==null||postorder.length==0) return null;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
        
    }
    
    private TreeNode buildTree(int[] inorder, int s1, int e1, int[]postorder, int s2, int e2){
        if(s1>e1||s2>e2) return null;
        
        TreeNode root=new TreeNode(postorder[e2]);
        int mid=map.get(postorder[e2]);
        int num=mid-s1;
        
        TreeNode left=buildTree(inorder, s1, mid-1, postorder, s2, s2+num-1);
        TreeNode right=buildTree(inorder, mid+1, e1, postorder, s2+num, e2-1);
        
        root.left=left;
        root.right=right;
        
        return root;
        
    }
}