/*
    Time:
        Best = O(n^2), Average = O(n^2), Worst = O(n^2)
    Space: O(1)
*/
class Solution {
    public int[] sortArray(int[] nums) {
        // Method 1
        // The very first number should be the first smallest element
        // for (int i = 0; i < nums.length - 1; i++) {
        //     int smallest = i;
        //     for (int j = i + 1; j < nums.length; j++) {
        //         // if this number is smaller than curr smallest update smallest
        //         if (nums[j] < nums[smallest]) {
        //             smallest = j;
        //         }
        //     }
        //     // Swap them
        //     swap(nums, i, smallest);
        // }
        
        // Method 2
        int index = 0;
        while (index < nums.length - 1) {
            int smallest = index;
            for (int j = index; j < nums.length; j++) {
                if (nums[j] < nums[smallest]) {
                    smallest = j;
                }
            }
            swap(nums, index, smallest);
            index++;
        }
        
        return nums;
    }
    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}