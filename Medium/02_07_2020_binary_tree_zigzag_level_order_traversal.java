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
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();

        if (root == null) {
            return levels;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        // Do a regular level order traversal
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> thisLevel = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                thisLevel.add(current.val);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                
            }
            levels.add(thisLevel);
        }
        
        boolean leftToRight = true;
        for (int i = 0; i < levels.size(); i++) {
            List<Integer> thisLevel = levels.get(i);
            if (leftToRight) {
                // This level is already ordered from left to right
                leftToRight = !leftToRight;
            } else {
                // reverse this order (right to left) to mimic the zigzag pattern
                Collections.reverse(thisLevel);
                leftToRight = !leftToRight;
            }
        }
        return levels;
        
    }
}