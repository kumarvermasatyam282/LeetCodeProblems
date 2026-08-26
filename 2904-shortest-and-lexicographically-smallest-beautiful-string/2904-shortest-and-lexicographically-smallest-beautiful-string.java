class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int left = 0;
        int count = 0;

        int minLen = Integer.MAX_VALUE;
        String res = "";

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                count++;
            }

            
            while (count == k) {

                int currLen = right - left + 1;
                String curr = s.substring(left, right + 1);

                
                if (currLen < minLen ||
                    (currLen == minLen && curr.compareTo(res) < 0)) {

                    minLen = currLen;
                    res = curr;
                }
                if (s.charAt(left) == '1') {
                    count--;
                }

                left++;
            }
        }

        return res;
    }
}