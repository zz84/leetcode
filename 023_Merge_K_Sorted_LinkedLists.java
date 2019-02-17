/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root = new ListNode(0);
        ListNode cur = root;
        while (findMin(lists) != -1) {
            int index = findMin(lists);
            cur.next = lists[index];
            lists[index] = lists[index].next;
            cur = cur.next;
        }
        return root.next;
    }
    
    //return the index with minimum value; -1 if all null.
    public int findMin(ListNode[] l) {
        int min = -1;
        int best = Integer.MAX_VALUE;
        for (int i = 0; i < l.length; i++) {
            if (l[i] == null) {
                continue;
            } else if (l[i].val < best) {
                min = i;
                best = l[i].val;
            } else {
                continue;
            }
        }
        return min;
    }
}
