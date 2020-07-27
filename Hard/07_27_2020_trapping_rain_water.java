// Time: O(n)
// Space: O(n)
import java.util.*;
class Solution {
    public int trap(int[] height) {
        int[] dp = new int[height.length];
        int leftMax = 0;
        // Populating left max
        for (int i = 0; i < height.length; i++) {
            dp[i] = leftMax;
            leftMax = Math.max(leftMax, height[i]);
        }
        // Populating the right max array
        int rightMax = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            int minMaxVal = Math.min(dp[i], rightMax);
            dp[i] = height[i] > minMaxVal ? 0 : minMaxVal - height[i];
            rightMax = Math.max(rightMax, height[i]);
        }
        return Arrays.stream(dp).sum();
    }
}