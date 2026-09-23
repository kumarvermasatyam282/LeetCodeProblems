class Solution {
    public int minOperations(int[] nums, int x) {
        int total_sum = 0;
        int n = nums.length;
        for (int ele : nums) {
            total_sum += ele;
        }
        int target = total_sum - x;
        if (target < 0) {
            return -1;
        }
        if (target == 0) {
            return nums.length;
        }
        int left = 0;
        int sum = 0;
        int maxlength = -1;
        for (int i = 0; i < n; i++) {
            sum+=nums[i];
            while(sum > target && left <= i){
                sum -= nums[left];
                left++;
            }
            if(sum==target) maxlength=Math.max(maxlength,i-left+1);
        }
        if(maxlength==-1) return -1;
        return n-maxlength;
    }
}