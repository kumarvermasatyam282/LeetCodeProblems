class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            // Build string from current rotation
            String result = new String(arr);
            if (result.equals(goal)) return true;

            // Perform one rotation: move first char to the end
            char first = arr[0];
            for (int j = 0; j < s.length() - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[s.length() - 1] = first;
        }
        return false;
    }
}
