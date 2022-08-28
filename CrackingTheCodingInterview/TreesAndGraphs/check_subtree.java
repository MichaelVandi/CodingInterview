public class MyClass {
    public static void main(String args[]) {

    }
    
    // Check subtree, do a preorder traversal, adding 
    // all nodes to a string including null nodes
    // and check the emerging strings for equality
    public void checkSubtree(TreeNode a, TreeNode b) {
        String a = getString(a, "");
        String b = getString(b, "");
        
        return a.contains(b);
        
    }
    public String getString(TreeNode node, String str) {
        if (node == null) {
            // You can optimze this with a String builder
            str += "X";
            return str;
        }
        // If the node is not null, add it's value to the str
        str += node.val.toString();
        // Now visit the left and right children nodes
        str += getString(node.left, str);
        str += getString(node.right, str);
        return str;
    }
    
    /*
        Alternative approach: only call the match function
        when you find b's root in a
    */
    public boolean isSubTree(TreeNode a, TreeNode b) {
        if (a == null) return false;
        // a is not null
        if (a.val = b.val) {
            // Call the match function
            String aStr = getString(a, "");
            String bStr = getString(b, "");
            if (aStr.contains(bStr) return true;
        }
        // if a is not equal to b, check other nodes in a
        return isSubTree(a.left, b) || isSubTree(a.right, b);
    }
    
    // You can also make a match function that compares nodes
    // in tandem like so
    
    public boolean match(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false; // Only one tree is null
        } else if (a.val != b.val) {
            return false;
        } else {
            // These current nodes are equal, check others
            return match(a.left, b.left) && 
                    match(a.right, b.right);
        }
    }

}