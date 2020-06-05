class Solution {
    // Time = O(n^2)
    // Space = O(n)
    public String longestPalindrome(String s) {
        if (s.length() > 0) {
            // Loop through the str
            String currentLongest = String.valueOf(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                // For palindrome pivoted at i
                int[] odd = getPalindrome(s, i - 1, i + 1);
                // For palindrome pivoted between i - 1 and i 
                int[] even = getPalindrome(s, i - 1, i);
                int[] longest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
                currentLongest = currentLongest.length() > longest[1] - longest[0] ?
                    currentLongest : s.substring(longest[0], longest[1]);
                
            }
            return currentLongest;
        }
        return s;
    }
    public int[] getPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return new int[] {left + 1, right};
    }
}