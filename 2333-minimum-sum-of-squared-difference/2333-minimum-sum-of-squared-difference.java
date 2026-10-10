class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int n = nums1.length;

        int[] differences = new int[n];

        long totalOperations = (long) k1 + k2;

        int maximumDifference = 0;
        long totalDifference = 0;

        for (int i = 0; i < n; i++) {
            differences[i] = Math.abs(nums1[i] - nums2[i]);

            totalDifference += differences[i];

            maximumDifference = Math.max(
                maximumDifference, differences[i]
            );
        }

        if (totalDifference <= totalOperations) {
            return 0;
        }

        int left = 0;
        int right = maximumDifference;

        while (left < right) {
            int middle = left + (right - left) / 2;

            long requiredOperations = 0;

            for (int difference : differences) {
                if (difference > middle) {
                    requiredOperations += difference - middle;
                }
            }

            if (requiredOperations <= totalOperations) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        int targetDifference = left;
        long remainingOperations = totalOperations;

        for (int difference : differences) {
            if (difference > targetDifference) {
                remainingOperations -= difference - targetDifference;
            }
        }

        long minimumSquareSum = 0;

        for (int difference : differences) {
            difference = Math.min(difference, targetDifference);

            if (difference == targetDifference
                    && remainingOperations > 0) {
                difference--;
                remainingOperations--;
            }
            minimumSquareSum += (long) difference * difference;
        }
        return minimumSquareSum;
    }
}