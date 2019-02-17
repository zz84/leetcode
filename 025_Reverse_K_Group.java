/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode count = head;
        int length = 0;
        while (count != null) {
            count = count.next;
            length++;
        }
        
        ListNode prev = root;
        ListNode cur = head;
        while (length >= k) {
            cur = prev.next;
            for (int i = 0; i < k - 1; i++) {
                ListNode temp = cur.next;
                cur.next = temp.next;
                temp.next = prev.next;
                prev.next = temp;
            }
            prev = cur;
            length = length - k;
        }
        return root.next;
    }
}
