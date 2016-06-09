/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // 空节点就直接返回  
        if(root == null){  
            return;  
        }  
          
        // 左节点非空，连接右节点  
        if(root.left != null){  
            root.left.next = root.right;  
        }  
          
        // 借助root.next处理5连6的情况  
        if(root.right!=null && root.next!=null){  
            root.right.next = root.next.left;  
        }  
          
        connect(root.left);  
        connect(root.right);
    }
}