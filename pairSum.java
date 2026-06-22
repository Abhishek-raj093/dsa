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

import java.util.*;

class Solution {
    public int pairSum(ListNode head) {
        List<Integer> temp = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            temp.add(node.val);
            node = node.next;
        }
        node = head;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < temp.size() / 2; i++) {
            res = Math.max(res, node.val + temp.get(temp.size() - 1 - i));
            node = node.next;
        }
        return res;
    }
}