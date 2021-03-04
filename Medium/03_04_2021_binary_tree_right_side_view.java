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
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        // Do a level order traversal
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // pop this element from the queue and add it's children
            List<Integer> thisLevel = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // Remove elements from this Level
                TreeNode node = queue.poll();
                // Add this to this level
                thisLevel.add(node.val);
                // Then add the children of this node to the queue
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                
            }
            // Add this list to the main list. but we don't need to we
            // Just need to get the last element in this level
            answer.add(thisLevel.get(thisLevel.size() - 1));
        }
        return answer;
    }
}