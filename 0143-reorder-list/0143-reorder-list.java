/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
    ListNode slow=head;
    ListNode fast=head;
    while(fast.next!=null&&fast.next.next!=null){
        //prev=slow;
        slow=slow.next;
        fast=fast.next.next;
    }
    ListNode second=slow.next;
    slow.next=null; 
    ListNode prev=null;
    ListNode curr=second; 
    while(curr!=null){
        ListNode next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
    }
    second=prev;
    ListNode first=head;
    
    while(first!=null&&second!=null){
        ListNode firstNext= first.next;
        ListNode secondNext= second.next;
        first.next=second;
        second.next=firstNext;
        first=firstNext;
        second=secondNext;
    }
    }
}