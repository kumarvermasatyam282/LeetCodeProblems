class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[][] arr = new int[26][2];
        for (int i = 0; i < 26; i++) {
            arr[i][0] = -1;
            arr[i][1] = -1;
        }
        // store the first and last occurence index in the charinterval array
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';

            if (arr[index][0] == -1) {
                arr[index][0] = i;
            }

            arr[index][1] = i;
        }
        // preprocessing
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (arr[i][0] == -1)
                continue;

            int firstoccur = arr[i][0];
            int lastoccur = arr[i][1];
            boolean valid = true;

            for (int j = firstoccur; j < lastoccur; j++) {
                int index = s.charAt(j) - 'a';

                if (arr[index][0] < firstoccur) {
                    valid = false;
                    break;
                }
                lastoccur = Math.max(lastoccur, arr[index][1]);

            }
            if (valid) {
                list.add(new int[] { firstoccur, lastoccur });
            }
        }

        list.sort((a, b) -> a[1] - b[1]);

        List<String> result = new ArrayList<>();
        int prevEnd = -1;
        for (int[] interval : list) {

            if (interval[0] > prevEnd) {

                String substring = s.substring(interval[0], interval[1] + 1);

                result.add(substring);

                prevEnd = interval[1];
            }
        }

        return result;
    }
}