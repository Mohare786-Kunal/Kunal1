class Solution {
    public void flatten(TreeNode root) {
        TreeNode[] prev = new TreeNode[1];
        flatten(root, prev);
    }
    
    private void flatten(TreeNode root, TreeNode[] prev) {
        if (root == null) return;
        TreeNode right = root.right;
        if (prev[0] != null) {
            prev[0].right = root;
            prev[0].left = null;
        }
        prev[0] = root;
        flatten(root.left, prev);
        flatten(right, prev);
    }
}