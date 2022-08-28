// Time: O(n)
// Space: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        // We look for the minimum price we have seen so far
        int minPriceSeen = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPriceSeen) {
                // This price is smaller than the minimum we've seen
                // It's now the new minimum
                minPriceSeen = price;
            } else {
                // This price is greater than the minimum we've seen
                // we might make a prifit here
                maxProfit = Math.max(maxProfit, price - minPriceSeen);
            }
        }
        return maxProfit;
    }
}