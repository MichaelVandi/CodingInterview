/*
* Time: O(n) or O(2^d) where n is the number of nodes and d is the depth of the binary tree
* Space: O(n) n frames on the call stack and also n total nodes stored in the answer
*/
class Solution {
	public List<Integer> answer = new ArrayList<>();
	public List<Integer> inorderTraversal(TreeNode root) {

		inorderTraversal(root.left);
		answer.add(root.val);
		inorderTraversal(root.right);
	
		return answer;
	}
}
