// Time: O(n) | Space: O(1)
public void moveElementsToEnd(int[] nums, int toMove) {
    // Initialize left and right pointers
    int left = 0;
    int right = nums.length - 1;
    for (int i = 0; i < nums.length; i++) {
        // Already in position, don't swap
        if(nums[right] == toMove) {
            right--;
        }
        if (nums[left] != toMove) {
            // It's not the element we want to swap
            left++;
        }
        if (nums[left] == toMove && nums[right] != toMove) {
            swap(left, right, nums);
            // Move pointers together
            left++;
            right--;
        }
    }
}
public void swap(int i, int j, int[] array) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}