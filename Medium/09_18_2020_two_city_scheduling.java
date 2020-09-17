/**
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int sum = 0;
        int n = costs.length / 2;
        int countA = 0;
        int countB = 0;
        
        int index = 0;
        Arrays.sort(costs, (a, b) -> Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1]));
        while (countA != n || countB != n) {
            // We still have people to send
            int costA = costs[index][0];
            int costB = costs[index][1];
            if (countA == n) {
                countB++;
                sum += costB;
            } else if (countB == n) {
                countA++;
                sum += costA;
            } else if (costA < costB) {
                countA++;
                sum += costA;
            } else if (costB < costA) {
                countB++;
                sum += costB;
            }
            index++;
        }
        return sum;
    }
}