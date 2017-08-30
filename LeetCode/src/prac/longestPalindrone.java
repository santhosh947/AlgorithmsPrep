package prac;

import java.sql.PreparedStatement;

public class longestPalindrone {

	public static void main(String[] args) {

		String str = "BANA";
		System.out.println(longestPlain(str));
		System.out.println(MachersAlgo(str));
	}

	private static String MachersAlgo(String str) {
		String processedStr = StringProcess(str);
		System.out.println(processedStr);
		int Center = 0, RightBound = 0;// index = 0;
		char[] T = processedStr.toCharArray();
		int[] p = new int[processedStr.length()];
		for (int index = 1; index < T.length - 1; index++) {
			int mirr = 2 * Center - index;
			if (index < RightBound) {
				p[index] = Math.min(RightBound - index, p[mirr]);
			} 

			while (T[index + p[index] + 1] == T[index - p[index] - 1]) {
				p[index]++;
			}

			if (index + p[index] > RightBound) {
				Center = index;
				RightBound = index + p[index];
			}
		}

		String output = "";
		for (int i = Center - p[Center]; i < Center + p[Center]; i++) {
			if (T[i] != '#')
				output += T[i];

		}

		return output;
	}

	private static String StringProcess(String str) {
		String processedStr = "~";
		for (int i = 0; i < str.length(); i++) {
			processedStr += "#" + str.charAt(i);
		}
		return processedStr + "#$";
	}

	private static String longestPlain(String str) {

		int max_len = 0; // index to store the max length of the palindrome
		int len = str.length();
		int palindromeBeginsAt = 0;
		boolean[][] palindroneTable = new boolean[len][len]; // boolean table to
																// store the
																// palindrome
																// true;

		// Mark all the diagonal elements value to True
		for (int i = 0; i < len; i++) {
			palindroneTable[i][i] = true;
		}
		// max_len=1;

		for (int i = 0; i < len - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				palindroneTable[i][i + 1] = true;
				palindromeBeginsAt = i;
				max_len = 2;
			}
		}

		for (int curr_len = 3; curr_len < len; curr_len++) {
			for (int i = 0; i < len - curr_len + 1; i++) {
				if (str.charAt(i) == str.charAt(i + curr_len - 1)
						&& palindroneTable[i + 1][i + curr_len - 2]) {
					palindromeBeginsAt = i;
					palindroneTable[i][i + curr_len - 1] = true;
					max_len = curr_len;
				}
			}
		}
		System.out.println(palindromeBeginsAt);
		System.out.println(max_len);
		return str.substring(palindromeBeginsAt, max_len + 1);
	}

}
