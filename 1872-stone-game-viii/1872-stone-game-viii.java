class Solution {
    public int stoneGameVIII(int[] stones) {

        int n = stones.length;

        int[] sum = new int[n];

        sum[0] = stones[0];

        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + stones[i];
        }

        int[] dp = new int[n];

        dp[n - 1] = sum[n - 1];

        for (int i = n - 2; i >= 1; i--) {
            dp[i] = Math.max(dp[i + 1], sum[i] - dp[i + 1]);
        }

        return dp[1];
    }
}