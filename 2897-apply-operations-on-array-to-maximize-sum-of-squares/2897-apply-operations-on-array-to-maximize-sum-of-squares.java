class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1000000007;
        int[] freq=new int[32];
        for(int ele : nums){
            for(int i=0;i<30;i++){
                if((ele & (1<<i)) !=0){
                    freq[i]++;
                }
            }
        }
        long res=0;
        for(int i=0;i<k;i++){
            long cur=0;
            for(int j=29;j>=0;j--){
                if(freq[j]!=0){
                    cur|=1L<<j;
                    freq[j]--;
                }
            }
            res=(res+cur*cur)%MOD;
        }
        return (int) res;
    }
}