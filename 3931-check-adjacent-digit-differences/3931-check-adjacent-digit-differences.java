class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        
        for (int i = 1; i < s.length(); i++) {
            int curr = s.charAt(i) - '0';
            int prev = s.charAt(i - 1) - '0';

            if (Math.abs(curr - prev) > 2) {
                return false;
            }
        }

        return true;
    }
}