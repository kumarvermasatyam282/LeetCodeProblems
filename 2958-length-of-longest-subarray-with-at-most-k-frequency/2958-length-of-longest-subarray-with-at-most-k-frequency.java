class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        int i=0;
        int maxlen=0;

        HashMap<Integer,Integer> table=new HashMap<>();
        for(int j=0;j<n;j++){
            table.put(nums[j],table.getOrDefault(nums[j],0)+1);
            while(table.get(nums[j])>k){
                table.put(nums[i],table.get(nums[i])-1);
                i++;
            }
            maxlen=Math.max(maxlen,j-i+1);
        }
        return maxlen;
    }
}