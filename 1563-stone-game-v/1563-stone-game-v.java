class Solution {
    static int[][] dp;

    public static int getmaxscore(int[] stoneValue, int i, int j,int[] prefix) {

        if (i >= j) {
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans = 0;

        // Try every possible partition
        for (int k = i; k < j; k++) {

            int leftSum = prefix[k+1]-prefix[i];
            int rightSum = prefix[j+1]-prefix[k+1];

            if (leftSum < rightSum) {

                ans = Math.max(
                    ans,
                    leftSum + getmaxscore(stoneValue, i, k,prefix)
                );

            } 
            else if (rightSum < leftSum) {

                ans = Math.max(
                    ans,
                    rightSum + getmaxscore(stoneValue, k + 1, j,prefix)
                );

            } 
            else {

                ans = Math.max(
                    ans,
                    leftSum + Math.max(
                        getmaxscore(stoneValue, i, k,prefix),
                        getmaxscore(stoneValue, k + 1, j,prefix)
                    )
                );
            }
        }
        dp[i][j]=ans; // storing the answer;
        return ans;
    }

    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }
        dp=new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getmaxscore(stoneValue,0,n-1,prefix);
    }
}