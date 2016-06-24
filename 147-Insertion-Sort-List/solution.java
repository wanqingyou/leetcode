/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        // if(head==null||head.next==null) return head;
        // ListNode cur=head;
        // ListNode rever=head;
        // ListNode pre=null;
        // ListNode p=null;
        
        // while(cur!=null){
        //     pre=cur;
        //     cur=cur.next;
        //     rever=cur;
        //     rever.next=pre;
        //     p=rever;
        //     int key=p.val;
        //     while(p.next!=null){
        //         if(key<p.next.val){
        //             p.val=p.next.val;
        //         }
        //         p=p.next;
        //     }
        //     p.val=key;
        // }
        
        // return head;
        
        if(head == null)  
            return null;  
        ListNode helper = new ListNode(0);  
        ListNode pre = helper;  
        ListNode cur = head;  
        while(cur!=null)  
        {  
            ListNode next = cur.next;  
            pre = helper;  
            while(pre.next!=null && pre.next.val<=cur.val)  
            {  
                pre = pre.next;  
            }  
            cur.next = pre.next;  
            pre.next = cur;  
            cur = next;  
        }  
        return helper.next;
    }
    
}