/*
 * Time: O(n + m)
 * Space: O(1)
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                // Set nums1[i] to the bigger number and decrement the pointers
                nums1[i--] = nums1[p1--];
            } else {
                // Set nums1[i] to the bigger number and decrement the pointers
                nums1[i--] = nums2[p2--];
            }
        }
        // While there are left over numbers from nums1, insert them into the final merged array
        while (p1 >= 0) {
            nums1[i--] = nums1[p1--];
        }
        // While there are left over numbers from nums2, insert them into the final merged array
        while (p2 >= 0) {
            nums1[i--] = nums2[p2--];
        }
    }
}