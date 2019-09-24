package zinjvi.leatcode;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class _2_AddTwoNumbers {
}


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode prev = head;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {
            int sum = 0;

            if(l1 != null && l2 != null) sum = l1.val + l2.val;
            else if (l1 != null) sum = l1.val;
            else if (l2 != null) sum = l2.val;

            sum = sum + carry;
            carry = sum / 10;

            ListNode current = new ListNode(sum % 10);
            prev.next = current;
            prev = current;


            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return head.next;
    }
}