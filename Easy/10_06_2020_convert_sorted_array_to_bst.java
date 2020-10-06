/**
 * Time: O(log (n))
 * Space: O(n)
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0 || nums == null) return null;
        return convert(nums, 0, nums.length - 1);
    }
    public TreeNode convert(int[] array, int start, int end) {
        if (start > end) return null;
        // Calculate median index
        int mid = start + (end - start) / 2;
        // Set median val to root
        TreeNode root = new TreeNode(array[mid]);
        // Determine left and right children
        // S for 'start', m for 'mid' and e for 'end'
        //  s           m           e
        //  x - x - x - x - x - x - x
        // You can see that the left side ranges from start to mid
        // And right side ranges from mid to end
        root.left = convert(array, start, mid - 1);
        root.right = convert(array, mid + 1, end);
        return root;
    }
    
    
}