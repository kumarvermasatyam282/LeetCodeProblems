class Solution {
    public int smallestIndex(int[] nums) {
        int ans=Integer.MAX_VALUE;
        boolean isexist=false;
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int sum=0;
            while(num>0){
                int rem=num%10;
                sum+=rem;
                num=num/10;
            }
            if(sum==i){
                ans=Math.min(ans,i);
                isexist=true;
            }
        }
        if(!isexist) return -1;
        return ans;
    }
}