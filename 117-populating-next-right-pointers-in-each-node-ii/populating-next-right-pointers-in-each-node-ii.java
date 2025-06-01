class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Node curr = root, nextLevel = null, nextHead = null;
        while (curr != null) {
            while (curr != null) {
                if (curr.left != null) {
                    if (nextLevel == null) {
                        nextHead = curr.left;
                        nextLevel = curr.left;
                    } else {
                        nextLevel.next = curr.left;
                        nextLevel = nextLevel.next;
                    }
                }
                if (curr.right != null) {
                    if (nextLevel == null) {
                        nextHead = curr.right;
                        nextLevel = curr.right;
                    } else {
                        nextLevel.next = curr.right;
                        nextLevel = nextLevel.next;
                    }
                }
                curr = curr.next;
            }
            curr = nextHead;
            nextHead = null;
            nextLevel = null;
        }
        return root;
    }
}