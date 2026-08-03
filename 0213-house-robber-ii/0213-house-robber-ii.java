class Solution {
    static int[] dp;
    public static int loot(int[] nums , int i,int end){
        if(i>end) return 0;

        if(dp[i]!=-1){
            return dp[i];
        }
        int pick=nums[i]+loot(nums , i+2,end);
        int skip=loot(nums,i+1,end);
        int maxloot=Math.max(pick , skip);
        dp[i]=maxloot;
        return maxloot;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(nums.length==1) return nums[0];
         // Case 1: Rob from 0 to n-2
       dp=new int[nums.length];

       Arrays.fill(dp,-1);
        int ans1=loot(nums,0,n-2);
        // Case 2: Rob from 1 to n-1;
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        int ans2=loot(nums,1,n-1);
        return Math.max(ans1,ans2);
    }
}