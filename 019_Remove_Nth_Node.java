/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int total = 1;
        while (cur.next != null) {
            cur = cur.next;
            total++;
        }
        if (total == 1) return null;
        if (total == n) return head.next;
        int count = 0;
        
        ListNode prev = head;
        while (count < total - n - 1) {
            prev = prev.next;
            count++;
        }
        if (n == 1) prev.next = null;
        else prev.next = prev.next.next;
        return head;
    }
}
