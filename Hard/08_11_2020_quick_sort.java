/*
    Time:
        Best = O(n log(n)), Average = O(n log(n)), Worst = O(n^2)
    Space: O(1)
*/
class Solution {
    public int[] sortArray(int[] nums) {
        
        applyQuickSort(nums, 0, nums.length - 1);
        return nums;
    }
    public void applyQuickSort(int[] array, int start, int end) {
        if (start >= end) return;
        int pointer = start;
        int left = start + 1;
        int right = end;
        while (left <= right) {
            // Left and right pointers are not in place so we swap them
            if (array[left] > array[pointer] && array[right] < array[pointer]) {
                swap(array, left, right);
            }
            // Left and right pointers are both in place
            if (array[left] <= array[pointer]) left++;
            if (array[right] >= array[pointer]) right--;  
        }
        swap(array, right, pointer);
        // Determine which sub array is smaller and apply quick sort to the smaller one first
        boolean leftIsSmaller = (right - 1) - start < end - (right + 1);
        if (leftIsSmaller) {
            // Apply quick sort on the left sub array first
            applyQuickSort(array, start, right - 1);
            applyQuickSort(array, right + 1, end);
        } else {
            // Apply quick sort on the right sub array first
            applyQuickSort(array, right + 1, end);
            applyQuickSort(array, start, right - 1);
        }

        
    }
    
    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}