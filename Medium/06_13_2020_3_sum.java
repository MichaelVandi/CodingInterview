// Time: O(n ^2 )
// Space: O(n)
import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || ( i > 0 && nums[i] != nums[i - 1])) {
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum > 0) {
                        // look in the left side
                        right--;
                    } else if (sum < 0) {
                        // Look on the right side
                        left++;
                        
                    } else {
                        triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left + 1]) left++;
                        while(left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }

                }
            }
           
        }
        return triplets;
    }
}