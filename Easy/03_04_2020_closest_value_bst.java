// Time: O(log(n)) | Space: O(log(n)) {AVERAGE CASE}
// Time: O(n) | Space: O(n) {WORST CASE}
public int closestValueInBST (BST tree, int target, double closest) {
    if (tree == null) {
        return 0;
    }
    // Calculate the difference between the target and the current node's value
    if (Math.abs(target - closest) > Math.abs(target - tree.value)) {
        closest = tree.value;
    }
    // You could also do the previous statement like this
    // closest = Math.abs(target - closest) > Math.abs(target - tree.value) ? tree.value : closest;
    if (target < tree.value && tree.left != null) {
        // Then we search on the left sub tree
        return closestValueInBST (tree.left, target, closest)
    }
    if (target > tree.value && tree.right != null) {
        // Then we search on the right sub tree
        return closestValueInBST (tree.right, target, closest)
    }
    return int(closest);
}

// public static void main (String args[] ) {
//     int closestValue = closestValueInBST(tree, 60, Double.MAX_VALUE);
// }
