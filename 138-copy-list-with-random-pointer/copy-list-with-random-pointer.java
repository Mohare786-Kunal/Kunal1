class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        Node dummy = new Node(0);
        Node copyCurr = dummy, originalCurr = head;
        while (originalCurr != null) {
            copyCurr.next = originalCurr.next;
            originalCurr.next = copyCurr.next.next;
            copyCurr = copyCurr.next;
            originalCurr = originalCurr.next;
        }
        return dummy.next;
    }
} 