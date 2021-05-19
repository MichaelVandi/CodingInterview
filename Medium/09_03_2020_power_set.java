/**
 * Prompt: Prompt: Given an integer array nums of unique elements, return all possible subsets (the power set).
    The solution set must not contain duplicate subsets. Return the solution in any order.
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerset = new ArrayList<>();
        // Add and empty subset
        powerset.add(new ArrayList<Integer>());
        for (int num : nums) {
            int length = powerset.size();
            for (int i = 0; i < length; i++) {
                // Copy the current subset
                List<Integer> current = new ArrayList<>(powerset.get(i));
                // Add current num to the current subset
                current.add(num);
                // Add new subset to the powerset
                powerset.add(current);
            }
        }
        return powerset;
    }
}


// Recursive Solution
// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> subsets = new ArrayList<>();
//         generateSubsets(subsets, new ArrayList<Integer>(), nums, 0);
//         return subsets;
        
        
//     }
//     public void generateSubsets(List<List<Integer>> result, 
//                                 List<Integer> subset, int[] nums, int index) {
//         result.add(new ArrayList<>(subset));
//         // Then we generate the remaining subsets and increment i for next iteration
//         for (int i = index; i < nums.length; i++) {
//             subset.add(nums[i]);
//             generateSubsets(result, subset, nums, i + 1);
//             subset.remove(subset.size() - 1);
//         }
//     }
// }
/*
    []
    
    Iter    val     subsize     curr            subset
    1       1           1        [] ->[1]        [ [], [1] ]
    2       2           2       [2], [1, 2]     [[], [1], [2], [1, 2]]
    3       3           4       [3], [1, 3], [2, 3] [1, 2, 3];
    

*/
