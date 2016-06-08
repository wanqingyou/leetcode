/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode p1=head;
        ListNode p2=head;
        
        while(p1!=null&&p2!=null){
            p1=p1.next;
            p2=p2.next;
            if(p2!=null){
                p2=p2.next;
            }
            if(p1==p2){
                break;
            }
        }
        if(p2 == null) return null;
         // 一起往下走X步，就找到节点了。
         p1 = head;
         while(p1!=p2)
         {
             p1 = p1.next;
             p2 = p2.next;
         }
         
         return p2;
    }
}