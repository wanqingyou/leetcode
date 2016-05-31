/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private LinkedList<Integer> data=new LinkedList<Integer>();
    private int count=0;
    private int size;

    public BSTIterator(TreeNode root) {
        inOrder(root);
        size=data.size();
    }
    
    private void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        data.add(root.val);
        inOrder(root.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return count<size?true:false;
    }

    /** @return the next smallest number */
    public int next() {
        return data.get(count++);
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */