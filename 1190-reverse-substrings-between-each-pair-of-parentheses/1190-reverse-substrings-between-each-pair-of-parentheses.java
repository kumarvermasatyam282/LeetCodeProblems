class Solution {

    public String reverseParentheses(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch != ')') {
                stack.push(ch);
            } 
            else {

                String result = "";

                while (stack.peek() != '(') {
                    result += stack.pop();
                }

                stack.pop();

                for (int j = 0; j < result.length(); j++) {
                    stack.push(result.charAt(j));
                }
            }
        }

        String ans = "";

        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }

        return ans;
    }
}