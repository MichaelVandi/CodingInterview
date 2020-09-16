/**
 * Time: O(n)
 * Space:O(1)
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int maxHere = nums[0];
        int runningMax = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            maxHere = Math.max(nums[i], nums[i] + maxHere);
            runningMax = Math.max(runningMax, maxHere);
        }
        return runningMax;
    }
}