// Time: O(n) | Space: O(n)
public List<Integer> branchSums (BinaryTree root) {
    List<Integer> sumsList = new ArrayList<>();
    return branchSums(root, 0, sumsList);
}
public List<Integers> branchSums (BinaryTree root, int sum, List<Integer> sumsList) {
    if (root == null) {
        return sumsList;
    }
    // sum = sum + root.value
    sum += root.value;
    if (root.left == null && root.right == null) {
        // Then we've hit a leaf node
        sumsList.add(sum);
    }
    if (root.left != null) {
        branchSums(root.left, sum, sumsList);
    }
    if (root.right != null) {
        branchSums (root.right, sum, sumsList);
    }
    // When everything's done, return sumsList
    return sumsList;

}