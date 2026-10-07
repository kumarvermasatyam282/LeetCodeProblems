import java.util.*;

class Solution {

    Set<String> result = new HashSet<>();
    int removeLeft;
    int removeRight;

    public List<String> removeInvalidParentheses(String s) {
         for (char ch : s.toCharArray()) {
            if (ch == '(') {
                removeLeft++;
            }
            else if (ch == ')') {

                if (removeLeft > 0) {
                    removeLeft--;
                }
                else {
                    removeRight++;
                }
            }
        }
        check(s, 0, 0, new StringBuilder());

        return new ArrayList<>(result);
        }

    void check(String s, int index, int open, StringBuilder current) {
        if (index == s.length()) {
            if (removeLeft == 0 &&
                removeRight == 0 &&
                open == 0) {
                result.add(current.toString());
            }
            return;
        }
        char ch = s.charAt(index);
        if (ch == '(') {
            if (removeLeft > 0) {
                removeLeft--;
                check(s, index + 1, open, current);
                removeLeft++;
            }
            current.append('(');
            check(s, index + 1, open + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
        else if (ch == ')') {
            if (removeRight > 0) {
                removeRight--;
                check(s, index + 1, open, current);
                removeRight++;
            }
            if (open > 0) {
                current.append(')');
                check(s, index + 1, open - 1, current);
                current.deleteCharAt(current.length() - 1);
            }
        }
        else {
            current.append(ch);
            check(s, index + 1, open, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}