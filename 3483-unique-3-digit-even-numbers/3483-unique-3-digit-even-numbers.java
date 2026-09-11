class Solution {
    public int totalNumbers(int[] digits) {

        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) {
                continue;
            }

            for (int j = 0; j < digits.length; j++) {
                if (j == i) {
                    continue;
                }

                for (int k = 0; k < digits.length; k++) {

                    if (k == i || k == j) {
                        continue;
                    }
                    if (digits[k] % 2 != 0) {
                        continue;
                    }

                    String r = "" + digits[i] + digits[j] + digits[k];

                    if (!arr.contains(r)) {
                        arr.add(r);
                    }
                }
            }
        }

        return arr.size();
    }
}