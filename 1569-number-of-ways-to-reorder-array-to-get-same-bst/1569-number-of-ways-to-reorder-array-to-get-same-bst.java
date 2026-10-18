
import java.util.*;

class Solution {
    static final long MOD = 1000000007;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        long[][] comb = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
            comb[i][i] = 1;

            for (int j = 1; j < i; j++) {
                comb[i][j] =
                    (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            list.add(x);
        }

        return (int) ((solve(list, comb) - 1 + MOD) % MOD);
    }

    private long solve(List<Integer> nums, long[][] comb) {
        int n = nums.size();

        if (n <= 2) {
            return 1;
        }

        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            int x = nums.get(i);

            if (x < root) {
                left.add(x);
            } else {
                right.add(x);
            }
        }

        long ways = comb[n - 1][left.size()];

        ways = ways * solve(left, comb) % MOD;
        ways = ways * solve(right, comb) % MOD;

        return ways;
    }
}
