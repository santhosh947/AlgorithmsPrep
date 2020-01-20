package Practice_Nov_2019;

import java.util.EventListener;
import java.util.Stack;

class L1249MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
      //  System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
        System.out.println(minRemoveToMakeValid("(a(b(c)d)"));

    }

    public static String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack();
        for(int i=0;i<s.length();i++)
        {
            if(sb.charAt(i)=='(')
                st.add(i+1);
            else if(sb.charAt(i)==')')
            {
                if(!st.isEmpty() && st.peek()>=0)
                    st.pop();
                else
                    st.add(-(i+1));
            }
            
        }
        while(!st.isEmpty())
            sb.deleteCharAt(Math.abs(st.pop())-1);
        
        return sb.toString();
    }

    public static String minRemoveToMakeValid_self(String s) {
        StringBuilder f_s = new StringBuilder();
        StringBuilder b_s = new StringBuilder();
        if (s == null || s.length() == 0)
            return s;

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) == ')')
                l++;
            else if (s.charAt(r) == '(')
                r--;
            else if (s.charAt(l) == '(') {
                if (s.charAt(r) == ')') {
                    f_s.append(s.charAt(l++));
                    b_s.append(s.charAt(r--));
                } else {
                    while (l < r) {
                        if (s.charAt(r) == ')') {
                            f_s.append(s.charAt(l++));
                            b_s.append(s.charAt(r--));
                            break;
                        } else if (s.charAt(r) == '(') {
                            r--;
                        } else {
                            b_s.append(s.charAt(r--));
                        }
                    }
                }
            } else if (s.charAt(r) == ')') {
                while (l < r) {
                    if (s.charAt(l) == '(') {
                        f_s.append(s.charAt(l++));
                        b_s.append(s.charAt(r--));
                        break;
                    } else if (s.charAt(l) == ')') {
                        l++;
                    } else {
                        f_s.append(s.charAt(l++));
                    }
                }
            } else {

                f_s.append(s.charAt(l++));
                b_s.append(s.charAt(r--));
            }
        }

        if(l==r)
        {
            if(!(s.charAt(l)==')' || s.charAt(r) == '('))
                f_s.append(s.charAt(l));
        }

        return f_s.toString() + b_s.reverse().toString();
    }
}