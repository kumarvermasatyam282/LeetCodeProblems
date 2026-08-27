class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int[] freq = new int[256];

        for (char c : s.toCharArray())
            freq[c]++;

        for (int i = target.length() - 1; i >= 0; i--) {

            int[] temp = freq.clone();

            boolean possible = true;

            for (int j = 0; j < i; j++) {
                if (temp[target.charAt(j)] == 0) {
                    possible = false;
                    break;
                }
                temp[target.charAt(j)]--;
            }

            if (!possible)
                continue;

            for (int c = target.charAt(i) + 1; c < 256; c++) {

                if (temp[c] > 0) {

                    StringBuilder ans = new StringBuilder();

                    ans.append(target, 0, i);


                    ans.append((char)c);
                    temp[c]--;
                    for (int x = 0; x < 256; x++) {
                        while (temp[x] > 0) {
                            ans.append((char)x);
                            temp[x]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}