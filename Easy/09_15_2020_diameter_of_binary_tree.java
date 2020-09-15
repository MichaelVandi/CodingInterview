/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 *  Time: O(n)
 *  Space: O(d) where d is the depth of the deepest branch
 */
class Solution {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        getDiameter(root);
        return ans - 1;
        
    }
    public int getDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // Get the length of the left child path
        int left = getDiameter(root.left);
        // Get the length of the right child path
        int right = getDiameter(root.right);
        // Update the answer
        ans = Math.max(ans, left + right + 1);
        // return the max of (left and right path) + 1
        return Math.max(left, right) + 1;
    }
}