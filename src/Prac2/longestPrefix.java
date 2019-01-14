package Prac2;

public class longestPrefix {
	public static void main(String[] args) {
		String[] in1 = {"flower","flow","flight"};
		String[] in2 = {"dog","racecar","car"};
		System.out.println(longestCommonPrefix(in1)); 
	}
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++)
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty())
					return "";
			}
		return prefix;
	}
}
