/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> nums=new ArrayList<Integer>();
        
        ListNode cur=head;
        while(cur!=null){
            nums.add(cur.val);
            cur=cur.next;
        }
        
        return dfs(nums, 0, nums.size()-1);
    }
    
    private TreeNode dfs(List<Integer> list, int start, int end){
        if(start>end) return null;
        
        int mid=(start+end)/2;
        TreeNode cur=new TreeNode(list.get(mid));
        TreeNode left=dfs(list, start, mid-1);
        TreeNode right=dfs(list, mid+1,end);
        cur.left=left;
        cur.right=right;
        return cur;
    }
}