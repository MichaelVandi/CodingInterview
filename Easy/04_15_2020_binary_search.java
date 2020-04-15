class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int center = (left + right) / 2;
            if (nums[center] == target) {
                // Amazing!
                return center;
            } else if (target < nums[center]) {
                // Look on the left side
                right = center - 1;
            } else if (target > nums[center]) {
                // Look on the right side
                left = center + 1;
            }
        }
        return -1;
    }
}