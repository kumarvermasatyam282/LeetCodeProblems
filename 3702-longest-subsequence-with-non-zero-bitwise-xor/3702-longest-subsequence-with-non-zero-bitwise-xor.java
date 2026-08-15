class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xor = 0;
        boolean hasNonZero = false;

        for (int i = 0; i < n; i++) {
            xor ^= nums[i];

            if (nums[i] != 0) {
                hasNonZero = true;
            }
        }

        if (xor != 0) {
            return n;
        }

        if (hasNonZero) {
            return n - 1;
        }

        return 0;
    }
}