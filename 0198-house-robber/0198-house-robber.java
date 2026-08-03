class Solution {
    static int[] dp;
    public static int loot(int[] nums , int i){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1) {
            return dp[i];
        }
       
        // either pick or skip options are there
        int pick=nums[i]+loot(nums , i+2 );
        int skip= loot(nums , i+1 );
        int maxloot=Math.max(pick ,skip);
        dp[i]=maxloot;

        return maxloot;
    }
    public int rob(int[] nums) {
         dp=new int[nums.length];
        Arrays.fill(dp,-1);
       return loot(nums , 0 );
    }
}