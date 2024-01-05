// Basic Calculator-II

import java.util.*;

class Solution {
    public int calculate(String s) {
        int result = 0;
        int num = 0;
        char oper = '+';

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);

            if (Character.isDigit(chr)) {
                num = num * 10 + (chr - '0');
            }

            if ((!Character.isDigit(chr) && chr != ' ') || i == s.length() - 1) {
                switch (oper) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                num = 0;
                oper = chr;
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}

