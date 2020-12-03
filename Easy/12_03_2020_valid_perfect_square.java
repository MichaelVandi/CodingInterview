/**
 * Time: O(log n)
 * Space: O(1)
 */
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        int left = 1;
        int right = num;
        while (right - left > 1) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                left = (int) mid;
            } else {
                right = (int) mid;
            }
        }
        return false;
    }
}