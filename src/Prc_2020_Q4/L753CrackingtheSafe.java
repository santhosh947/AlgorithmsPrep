package Prc_2020_Q4;

import java.util.*;

public class L753CrackingtheSafe {
    public static void main(String[] args) {
        System.out.println(crackSafe(2, 2));
    }

    public static String crackSafe(int n, int k) {
        String pwd_str = String.join("", Collections.nCopies(n, "0"));

        StringBuilder pwd = new StringBuilder(pwd_str);

        Set<String> visitedPwd = new HashSet();
        visitedPwd.add(pwd_str);
        int totalPwd = (int) Math.pow(k, n);

        breakSafe(pwd, visitedPwd, n, k, totalPwd, pwd_str);
        return pwd.toString();
    }

    private static boolean breakSafe(StringBuilder pwd, Set<String> visitedPwd, int n, int k, int totalPwd,
            String pwd_current) {
        if (visitedPwd.size() == totalPwd) {
            return true;
        }

        String lastStr = pwd_current.substring(pwd_current.length() - n + 1);

        for (char c = '0'; c < '0' + k; c++) {
            String new_pwd = lastStr + c;
            if (!visitedPwd.contains(new_pwd)) {
                visitedPwd.add(new_pwd);
                pwd.append(c);
                if (breakSafe(pwd, visitedPwd, n, k, totalPwd, new_pwd)) {
                    return true;
                }
                visitedPwd.remove(new_pwd);
                pwd.deleteCharAt(pwd.length() - 1);
            }
        }
        return false;
    }

}
