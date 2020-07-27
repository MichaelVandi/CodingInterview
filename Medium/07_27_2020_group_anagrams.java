// Time: O(n * s log s) where n is the number of strings and s
// is the length of the longest string
// Space: O(ns)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] sorted = str.toCharArray();
            Arrays.sort(sorted);
            String sortedStr = new String(sorted);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<String>());
            }
            // Add to the list of anagrams for this sorted key
            map.get(sortedStr).add(str);
        }
        anagrams.addAll(map.values());
        return anagrams;
    }
}