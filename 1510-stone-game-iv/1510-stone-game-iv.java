class Solution {
    static boolean[] dp;

    public static boolean winner(int n ){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;

                if (!dp[i - square]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];

    }

    public boolean winnerSquareGame(int n) {
        dp=new boolean[n+1];
        return winner(n);
    }
}