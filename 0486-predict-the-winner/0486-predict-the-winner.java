class Solution {

    public boolean predictTheWinner(int[] nums) {
        return solve(nums, 0, nums.length - 1) >= 0;
    }

    private int solve(int[] nums, int left, int right) {
        // Base case: only one element left
        if (left == right) {
            return nums[left];
        }

        // Choose the left number
        int pickLeft = nums[left] - solve(nums, left + 1, right);

        // Choose the right number
        int pickRight = nums[right] - solve(nums, left, right - 1);

        // Return the best score difference
        return Math.max(pickLeft, pickRight);
    }
}