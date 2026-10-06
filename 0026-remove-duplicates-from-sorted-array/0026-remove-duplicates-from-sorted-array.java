class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int i=0;
        int j=1;
        int distinct=0;
        while(i<n && j<n){
            if(nums[i]==nums[j]) j++;
            else{
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
}