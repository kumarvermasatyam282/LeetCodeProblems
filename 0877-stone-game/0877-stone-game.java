class Solution {
    public boolean stoneGame(int[] nums) {
        int n=nums.length;
       int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=nums[i];
        }   
        
        for(int len=2;len<=n;len++){
            for(int left=0;left<=n-len;left++){
                int right=n-1-left;
                int pickleft=nums[left]-dp[left+1][right];
                int pickright=nums[right]-dp[left][right-1];
                dp[left][right]=Math.max(pickleft , pickright);
            }
        }
        return dp[0][n-1]>0;
    }
}