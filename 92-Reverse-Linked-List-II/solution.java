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
        ListNode p1;
        ListNode p2;
        int count=1;
        ListNode cur=head;
        while(count<m-1){
            cur=cur.next;
            count++;
        }
        ListNode firstTail=cur;
        cur=cur.next;
        ListNode firstHead=cur;
        count++;
        p1=cur;
        p2=cur;
        while(count<n){
            p1=cur;
            cur=cur.next;
            p2=cur;
            p2.next=p1;
            count++;
        }
        firstTail.next=p2;
        if(firstHead!=null)
            firstHead.next=p2.next;
        return head;
    }
}