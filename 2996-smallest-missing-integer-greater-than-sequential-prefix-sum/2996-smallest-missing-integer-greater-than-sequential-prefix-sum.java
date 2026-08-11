class Solution {
    public int missingInteger(int[] nums) {
        int i = 1;
        int end=0;
        int prefixsum = nums[0];
        while (i < nums.length && nums[i]-nums[i-1]==1) {
                prefixsum += nums[i];
                i++;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int j = 0; j < nums.length; j++) {
            set.add(nums[j]);
        }
        if (!set.contains(prefixsum)) {
            return prefixsum;
        }
        while (set.contains(prefixsum)) {
             prefixsum++;
        }
        return prefixsum;
    }
}