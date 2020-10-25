/**
 * Time: O(n) or O(2^d) -> where d is the depth of the binary tree
 * Space: O(d) -> where d is the depth of the binary tree
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSum(root, sum, 0);
        
    }
    public boolean hasPathSum(TreeNode root, int target, int running) {
        if (root == null) {
            return false;
        }
        // Add current value to running sum
        running += root.val;
        // Check if we are at a leaf node
        if (root.left == null && root.right == null) {
            // return whether this path adds up to target
            return running == target;
        }
        // Go to the left and right paths
        return hasPathSum(root.left, target, running) ||
            hasPathSum(root.right, target, running);
    }
}