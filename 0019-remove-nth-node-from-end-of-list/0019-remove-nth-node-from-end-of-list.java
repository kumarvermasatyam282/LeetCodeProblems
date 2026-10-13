class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) return null;

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }
        while (fast != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        prev.next = slow.next;

        return head;
    }
}
