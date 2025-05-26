class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        tail.next = head;
        k = k % length;
        for (int i = 0; i < length - k; i++) tail = tail.next;
        head = tail.next;
        tail.next = null;
        return head;
    }
}