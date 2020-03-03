// Time: O(n) | Space: O(d) where d is te numbher of duplicates that we found.
import java.util.*;
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> answer = new ArrayList<>();
        int left = 0;
        while (left < nums.length - 1) {
            if (nums[left] == nums[left + 1]) {
                answer.add(nums[left]);
                left ++;
            }
            left ++;
        }
        return answer;
    }
}