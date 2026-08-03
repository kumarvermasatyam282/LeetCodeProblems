class Solution {
    public static int take(int i , int[] nums , int[] dp){
        int n=nums.length;
        if(i>=n){
            return 0;
        }
        if(dp[i] !=Integer.MIN_VALUE) {
            return dp[i];
        }
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int j=0 ;j<3 && j+i < n;j++){
            sum+=nums[j+i];
            max=Math.max(max,sum-take(i+j+1 , nums ,dp));
        }
        dp[i]=max;
        return max;
    }
    public String stoneGameIII(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int score=take(0,nums,dp);
        if (score > 0) return "Alice";
        if(score < 0) return "Bob";
        return "Tie";
    }
}