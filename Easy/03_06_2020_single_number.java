import java.util.*;
class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            if (set.contains(num)) {
                // This is the second occurence, remove num from hash set
                set.remove(num);
            } else {
                // This is the first occurence, add it to a hashset
                set.add(num);
            }
        }
        // Go through all the values in set and return the first value
        for (int num : set) {
            return num;
        }
        return 0;
    }
}