class Solution {
    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        int[] freq = new int[26];

        // Count characters
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Find odd frequency characters
        int odd = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                odd++;
                middle = (char) ('a' + i);
            }
        }

        // Palindrome is impossible
        if (odd > 1) {
            return "";
        }

        int halfLen = n / 2;

        int[] halfFreq = new int[26];

        // Frequency of characters in first half
        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        String targetHalf = target.substring(0, halfLen);

        int[] temp = halfFreq.clone();

        boolean possibleEqual = true;

        // Check whether targetHalf can be formed
        for (char c : targetHalf.toCharArray()) {

            if (temp[c - 'a'] == 0) {
                possibleEqual = false;
                break;
            }

            temp[c - 'a']--;
        }

        // If targetHalf can be formed,
        // check whether its palindrome is greater than target
        if (possibleEqual) {

            String palindrome =
                    makePalindrome(targetHalf, middle, n);

            if (palindrome.compareTo(target) > 0) {
                return palindrome;
            }
        }

        // Find smallest half greater than targetHalf
        String half = nextGreaterHalf(halfFreq, targetHalf);

        if (half.equals("")) {
            return "";
        }

        return makePalindrome(half, middle, n);
    }


    public String nextGreaterHalf(int[] freq, String target) {

        int m = target.length();

        // Start from the RIGHTMOST position
        for (int i = m - 1; i >= 0; i--) {

            int[] remaining = freq.clone();

            boolean valid = true;

            // Match target[0 ... i-1]
            for (int j = 0; j < i; j++) {

                int ch = target.charAt(j) - 'a';

                if (remaining[ch] == 0) {
                    valid = false;
                    break;
                }

                remaining[ch]--;
            }

            if (!valid) {
                continue;
            }

            // Find smallest character greater than target[i]
            int current = target.charAt(i) - 'a';

            for (int ch = current + 1; ch < 26; ch++) {

                if (remaining[ch] > 0) {

                    StringBuilder result = new StringBuilder();

                    // Same prefix
                    result.append(target.substring(0, i));

                    // Slightly bigger character
                    result.append((char) ('a' + ch));

                    remaining[ch]--;

                    // Fill remaining characters in sorted order
                    for (int k = 0; k < 26; k++) {

                        while (remaining[k] > 0) {
                            result.append((char) ('a' + k));
                            remaining[k]--;
                        }
                    }

                    return result.toString();
                }
            }
        }

        return "";
    }


    private String makePalindrome(String half, char middle, int n) {

        StringBuilder result = new StringBuilder();

        result.append(half);

        // Middle character for odd length
        if (n % 2 == 1) {
            result.append(middle);
        }

        // Reverse the first half
        for (int i = half.length() - 1; i >= 0; i--) {
            result.append(half.charAt(i));
        }

        return result.toString();
    }
}