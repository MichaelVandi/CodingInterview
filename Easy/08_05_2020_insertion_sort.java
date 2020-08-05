/*
    Time:
        Best = O(n), Average = O(n^2), Worst = O(n^2)
    Space: O(1)
*/
class Solution {
    public int[] sortArray(int[] nums) {
        // The very first number by itself is sorted
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j > 0) {
                // Insert nums j into its rightful position in the sorted array
                if (nums[j] < nums[j - 1]) {
                    // Swap them
                    swap(nums, j, j - 1);
                }
                j--;
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