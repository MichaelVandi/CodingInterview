/**
 * This code has been checked for syntax errors and typos, 
 * some of the code in CTCI folder haven't. Hit me up if you want to run them
 * and check for typos :) love
 */
import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        int[] nums = new int[] {
            1, 2, 4, 6, 8, 10, 12, 14, 16
        };
        TreeNode node = new TreeNode(0);
        for (int num : nums) {
            node.insert(num);
        }
        // Now we can use the get random node function
        for (int i = 0; i < 10; i++) {
            TreeNode random = node.getRandomNode();
            System.out.println(random.data);
        }

    }
  
}
class TreeNode {
    int data;
    int size;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int d) {
        this.data = d;
        this.size = 1;
    }
    // Get Random node
    public TreeNode getRandomNode() {
        int leftSize = this.left == null ? 0 : this.left.size;
        // Generate a Random
        Random random = new Random();
        // Get a random node the size of this subtree
        int index = random.nextInt(this.size);
        // Now we can check if this random index is to the left
        // or right
        if (index < leftSize) {
            return this.left.getRandomNode();
        } else if (index == leftSize) {
            return this;
        } else {
            return this.right.getRandomNode();
        }
        
        
    }
    
    // Insert
    public void insert(int val) {
        if (val < this.data) {
            // Go left
            if (this.left == null) {
                // set it to this.left
                TreeNode node = new TreeNode(val);
                this.right = node;
            } else {
                // recurse on the left side
                this.left.insert(val);
            }
        } else {
            // Go right
            if (this.right == null) {
                // set it to this.right
                TreeNode node = new TreeNode(val);
                this.right = node;
            } else {
                this.right.insert(val);
            }
        }
        this.size += 1;
    }
    // Return size and data
    public int size() {
        return this.size;
    }
    public int data() {
        return this.data;
    }
}