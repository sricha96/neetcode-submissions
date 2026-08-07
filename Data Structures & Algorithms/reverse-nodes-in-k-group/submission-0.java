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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode groupPrev = dummy;
        while(true){
            ListNode kth = getKthNode(groupPrev, k);
            if(kth == null){
                break;
            }
            ListNode groupNext = kth.next;
            ListNode prev = kth.next;
            ListNode curr = groupPrev.next;
            while(curr != groupNext){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }
        return dummy.next;
    }

    public ListNode getKthNode(ListNode current, int k){
        while(current != null && k > 0){
            current = current.next;
            k--;
        }
        return current;
    }
}
