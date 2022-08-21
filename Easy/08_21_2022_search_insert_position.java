/**
    LeetCode 35
    Time: O(n)
    Space: O(1)
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) return 0;
            if (nums[0] < target) return 1;
            if (nums[0] > target) return 0;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int current = nums[i];
            int next = nums[i + 1];
            if (current == target) return i;
            if (target >= current && target <= next) {
                return (i + 1);
            }
        }
        // Did not find position in array. It could be first or last
        if (nums[0] >= target) {
            return 0;
        }
        return nums.length;
        
    }
}