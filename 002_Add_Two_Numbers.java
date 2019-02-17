/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        int carryb = 0;
        ListNode cur = root;
        while (l1!=null || l2!=null || carryb!=0) {
            int sum = ((l1!=null) ? l1.val : 0) + ((l2!=null) ? l2.val : 0) + carryb;
            cur.next = new ListNode(sum % 10);
            carryb = sum/10;
            l1 = (l1!=null) ? l1.next : l1;
            l2 = (l2!=null) ? l2.next : l2;
            cur = cur.next;
        }
        return root.next;
    }
}
