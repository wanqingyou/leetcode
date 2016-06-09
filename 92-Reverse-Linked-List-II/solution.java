/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // ListNode p1;
        // ListNode p2;
        // int count=1;
        // ListNode cur=head;
        // while(count<m-1){
        //     cur=cur.next;
        //     count++;
        // }
        // ListNode firstTail=cur;
        // cur=cur.next;
        // ListNode firstHead=cur;
        // count++;
        // p1=cur;
        // p2=cur;
        // while(count<n){
        //     p1=cur;
        //     cur=cur.next;
        //     p2=cur;
        //     p2.next=p1;
        //     count++;
        // }
        // firstTail.next=p2;
        // if(firstHead!=null)
        //     firstHead.next=p2.next;
        // return head;
        
        if(head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preNode = dummy;
        int i=1;
        while(preNode.next!=null && i<m)
        {
            preNode = preNode.next;
            i++;
        }
        if(i<m)
            return head;
        ListNode mNode = preNode.next;
        ListNode cur = mNode.next;
        while(cur!=null && i<n)
        {
            ListNode next = cur.next;
            cur.next = preNode.next;
            preNode.next = cur;
            mNode.next = next;
            cur = next;
            i++;
        }
        return dummy.next;
    }
}