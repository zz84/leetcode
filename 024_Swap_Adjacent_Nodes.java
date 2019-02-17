/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode(0);
        ListNode cur = root;
        cur.next = head;
        while (cur.next != null && cur.next.next != null) {
            ListNode prev = cur.next;
            ListNode after = cur.next.next;
            cur.next = after;
            prev.next = after.next;
            after.next = prev;
            cur = prev;
        }
        return root.next;
    }
}
