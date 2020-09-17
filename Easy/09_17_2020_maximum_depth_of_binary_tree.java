/**
 * Time: O(n)
 * Space: O(d) where d is the depth of the deepest path
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        // Find the length of the left and right children paths
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // return the max of left and right length plus 1
        return Math.max(left, right) + 1;
    }
}