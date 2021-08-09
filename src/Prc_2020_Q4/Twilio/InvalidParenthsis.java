package Prc_2020_Q4.Twilio;

import java.util.*;

public class InvalidParenthsis {
    public static void main(String[] args) {
        //System.out.println("|this is valid|" + "->" + isValidParenthesis("|this is valid|"));

        System.out.println("[abc|cde]" + "->" + isValidParenthesis("[abc|cde]"));
        System.out.println("]nn|" + "->" + isValidParenthesis("]nn|"));
        System.out.println("><" + "->" + isValidParenthesis("><"));
        System.out.println(">||<" + "->" + isValidParenthesis(">||<"));
        System.out.println("|||" + "->" + isValidParenthesis("|||"));
        System.out.println("[...|...]|" + "->" + isValidParenthesis("[...|...]|"));

        System.out.println("|this is valid|" + "->" + isValidParenthesis("|this is valid|"));
        System.out.println("|[also valid]|" + "->" + isValidParenthesis("|[also valid]|"));
        System.out.println("<||>" + "->" + isValidParenthesis("<||>"));

        System.out.println("|[]|" + "->" + isValidParenthesis("|[]|"));
        System.out.println("|[v<a<l>i>d]|" + "->" + isValidParenthesis("|[v<a<l>i>d]|"));

    }

    public static boolean isValidParenthesis(String str) {
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put('<', '>');
        mapping.put('[', ']');
        mapping.put('|', '|');

        Stack<Character> st = new Stack<>();
        Set<Character> set = new HashSet<>();

        set.add('<');
        set.add('>');
        set.add('[');
        set.add(']');

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '|') {
                if(!st.isEmpty() && st.peek() == '|'){
                    st.pop();
                }
                else {
                    st.push('|');
                }                
            } 
            else if (mapping.containsKey(ch)) {
                st.push(mapping.get(ch));
            } else {
                if (set.contains(ch)) {
                    if (st.isEmpty()) {
                        return false;
                    }
                    char closing_ch = st.pop();
                    if (closing_ch != ch) {
                        return false;
                    }
                }
            }
        }

        return st.isEmpty();
    }

}
