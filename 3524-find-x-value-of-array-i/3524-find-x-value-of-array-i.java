class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n=nums.length;
        long[] dp=new long[k];
        long[] result=new long[k];
        
        for(int num:nums){
            long[] newdp=new long[k];
            int nummod=num%k;

            newdp[nummod]+=1;

            for(int j=0;j<k;j++){
                if(dp[j]>0){
                    int newR=(j*nummod)%k;
                    newdp[newR]+=dp[j];
                }
            }
            for(int r=0;r<k;r++){
                result[r]+=newdp[r];
            }
            dp=newdp;
        }
        return result;
    }
}