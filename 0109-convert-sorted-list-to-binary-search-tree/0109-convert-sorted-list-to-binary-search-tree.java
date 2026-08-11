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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
    ListNode prev=null;
    ListNode slow = head;
    ListNode fast = head;
    while(fast!=null &&fast.next!=null){
        prev=slow;
        slow=slow.next;
        fast=fast.next.next;
    }
    ListNode right=slow.next;
    if(prev!=null){
        prev.next=null;
    }
    TreeNode root=new TreeNode(slow.val);
    if (prev != null) {
            root.left = sortedListToBST(head);
        }
    root.right= sortedListToBST(right);
    return root;
    }
}