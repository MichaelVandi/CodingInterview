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
class BSTIterator {
    // First solution flatten the bst
    // List<Integer> list;
    // int index;
    Stack<TreeNode> stack;
    
    // public void inOrderTraversal(TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }
    //     // Check left node
    //     inOrderTraversal(root.left);
    //     // Process this node
    //     list.add(root.val);
    //     // Check right node
    //     inOrderTraversal(root.right);
    // }

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<TreeNode>();
        // index = -1;
        // // Do the inOrderTraversal
        // inOrderTraversal(root);
        // Add all the leftmost elements to a stack so the smallest will be on top
        addLeftmost(root);
        
    }
    public void addLeftmost(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
    
    public int next() {
        // // Return the value at index + 1
        // if (hasNext()) {
        //     index += 1;
        //     return list.get(index); 
        // } else {
        //     return -1;
        // }
        TreeNode top = stack.pop();
        if (top.right != null) {
            // We have a right branch, add the leftmost element in this right branch
            // To maintain the smallest at top property
            addLeftmost(top.right);
        }
        return top.val;
    }
    
    public boolean hasNext() {
        return stack.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */