package prac;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CTCI_ch01_p4_StringManipulation {
	public static void main(String[] args) {
		String str = "Tact Coa";
		String strWithoutSpaces = removeSpaces(str.toLowerCase());
		if (strWithoutSpaces.length() % 2 == 0)
			System.out.println(checkIfPalindromeIsPossible(strWithoutSpaces,
					true));
		else
			System.out.println(checkIfPalindromeIsPossible(strWithoutSpaces,
					false));

	}

	private static boolean checkIfPalindromeIsPossible(String s, boolean b) {
		int index = 0;
		if (b == false)
			index = 1;

		Map<Character, Integer> hm = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			if (hm.get(s.charAt(i)) != null) {
				int v = hm.get(s.charAt(i));
				hm.put(s.charAt(i), ++v);
			} else
				hm.put(s.charAt(i), 1);
		}

		Iterator it = hm.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			int val = (int) pair.getValue();
			if(val%2==1 && index==0)
				return false;
			if(val%2==1)
				index--;
			it.remove();
		}
		return true;
	}

	private static String removeSpaces(String str) {
		char[] charrr = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char ch : charrr) {
			if (ch != ' ')
				sb.append(ch);
		}
		return sb.toString();
	}

	private static String replaceSpace(String string) {
		char[] chArr = string.toCharArray();
		int len = string.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			if (chArr[i] == ' ') {
				sb.append("%20");
				len = len - 2;
			} else
				sb.append(chArr[i]);
		}
		return sb.toString();
	}

}
