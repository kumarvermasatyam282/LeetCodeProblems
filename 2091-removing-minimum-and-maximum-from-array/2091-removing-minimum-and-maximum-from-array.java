class Solution {
    public int minimumDeletions(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (max < nums[i]){
                max = nums[i];
                minIndex=i;
            }
            if (min > nums[i]){
                min = nums[i];
                maxIndex=i;
            }
        }
        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);

        int deleteFromLeft = right + 1;

        int deleteFromRight = n - left;

        int deleteBothSides = (left + 1) + (n - right);

        return Math.min(
            deleteFromLeft,
            Math.min(deleteFromRight, deleteBothSides)
        );
    }
}