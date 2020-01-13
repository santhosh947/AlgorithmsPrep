package Practice_Nov_2019;

import java.util.*;

class L20ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack();
        Map<Character, Character> hm = new HashMap();
        hm.put(')', '(');
        hm.put('}', '{');
        hm.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ')' || c == '}' || c == ']') {
                if (st.isEmpty())
                    return false;
                else {
                    char op = st.pop();
                    if (hm.get(c) != op)
                        return false;
                }
            } else {
                st.push(c);
            }

        }

        return true;
    }
}