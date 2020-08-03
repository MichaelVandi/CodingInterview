/*
    Time:
        Best = O(n), Average = O(n^2), Worst = O(n^2)
    Space: O(1)
*/
class Solution {
    public int[] sortArray(int[] nums) {
        // Assume the array is not sorted
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < nums.length - 1; i++) {
                // If current number is greater than the next
                if (nums[i] > nums[i + 1]) {
                    // Swap them
                    swap(nums, i, i + 1);
                    // If we made a swap, then let's go through one more iteration
                    isSorted = false;
                }
            }
        }
        return nums;
    }
    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}