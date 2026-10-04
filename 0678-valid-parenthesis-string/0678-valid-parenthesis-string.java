class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                minOpen++;
                maxOpen++;
            }
            else if (s.charAt(i) == ')') {
                minOpen--;
                maxOpen--;
            }
            else { // '*'
                minOpen--; // '*' acts as ')'
                maxOpen++; // '*' acts as '('
            }
            if (minOpen < 0) {
                minOpen = 0;
            }
            if (maxOpen < 0) {
                return false;
            }
        }

        return minOpen == 0;
    }
}