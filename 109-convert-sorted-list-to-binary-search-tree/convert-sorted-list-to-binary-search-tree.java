class Solution {
    private ListNode head;
    
    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        int size = getSize(head);
        return sortedListToBST(0, size - 1);
    }
    
    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
    
    private TreeNode sortedListToBST(int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        root.left = left;
        root.right = sortedListToBST(mid + 1, end);
        return root;
    }
}