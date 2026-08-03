class Solution {
    public int findGCD(int[] nums) {
        int gdc=1;
        int n=nums.length;
        Arrays.sort(nums);
        int mn=nums[0];
        int mx=nums[n-1];
        if(mn==mx) {return mx;}
        for(int i=1;i<mx;i++){
            if(mn%i==0 && mx%i==0) gdc=i;
        }
         return gdc;
    }
}