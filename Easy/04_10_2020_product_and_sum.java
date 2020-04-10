class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while (n >= 1) {
            int lastDigit = n % 10;
            product = product * lastDigit;
            sum += lastDigit;
            n = n / 10;
        }
        return product - sum;
    }
}