class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        int heightDiff = Math.abs(leftDepth - rightDepth);
        if (heightDiff > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }
    public int getDepth(TreeNode root) {
        if (root == null) return -1;
        // System.out.println(root.val);
        int depthHere = Math.max(getDepth(root.left), getDepth(root.right)) + 1;
        return depthHere;
        
    }
}