public class MyClass {
    public static void main(String args[]) {

    }
    
    // Traverse from one node upwards
    public findAncestor(TreeNode p, TreeNode q) {
        
    }
    public findAncestor(TreeNode child, TreeNode parent,
            TreeNode q) {
        if (child == q) {
            // Q has been found
        }        
        if (parent.left == child) {
            // Newly uncovered tree is the right
            // Find q in this tree rooted at this parent
            if (findChild(parent.right, q)) return parent;
            // We did not find q on this subtree, so we
            // move up
            return findAncestor(parent, parent.parent, q);
            
        } else {
            // Newly uncovered tree is the left
            if (findChild(parent.right, q)) return parent;
            return findAncestor(parent, parent.parent, q);
            
        }
    }
    public boolean findChild(TreeNode parent, 
            TreeNode child) {
        // Use a simple dfs algorithm to search
        if (parent == null) {
            return false;
        }
        // Visit this node.
        if (parent == child) {
            return true;
        }
        return findChild(parent.left, child) || 
            findChild(parent.right, child);
    }
    
}