/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head==null) return;
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //slow is the head of the second half list
        ListNode secH=slow.next;
        slow.next=null;
        ListNode pre=null;
        while(secH!=null){
            fast=secH;
            secH=secH.next;
            fast.next=pre;
            pre=fast;
        }
        
        ListNode cur=head;
        while(cur!=null&&pre!=null){
            ListNode nextNode=cur.next;
            cur.next=pre;
            ListNode secHNext=pre.next;
            pre.next=nextNode;
            cur=nextNode;
            pre=secHNext;
        }
    }
}