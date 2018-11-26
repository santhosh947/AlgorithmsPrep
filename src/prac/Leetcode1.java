package prac;

public class Leetcode1 {
	public static void main(String[] args) {
		// System.out.println(findlength("abc", "dfg"));

		// String[] arr = { "aabbcc", "aabbcc","cb","abc"};

		String[] arr = { "aaa", "aaa", "ab" };

		System.out.println(findLUSlength(arr));

	}

	/*
	 * public static int findLUSlength(String[] strs) { int seq = -1; int temp =
	 * -1; for (int i = 0; i < strs.length - 1; i++) { for (int j = i + 1; j <
	 * strs.length; j++) { temp = -1; temp = findsubStr(strs[i], strs[j]); if
	 * (temp > seq) { seq = temp; } } } return seq;
	 * 
	 * }
	 */

	public static int findLUSlength(String[] strs) {
		int[] arr = new int[strs.length];
		int seq = -1;
		int temp = -1;
		for (int i = 0; i < strs.length - 1; i++) {
			// if (arr[i] != 1) {
			for (int j = i + 1; j < strs.length; j++) {
				if (arr[j] != 1) {
					temp = -1;
					if (arr[i] == 1) {
						
					} else {
						temp = findsubStr2(strs[i], strs[j]);
					}
					if (temp == -1) {
						arr[i] = 1;
						arr[j] = 1;
						break;
					}
					if (temp > seq) {
						seq = temp;
					}
				}
			}
			// }

			if (i == strs.length - 2 && seq == -1 && arr[i + 1] == 0) {
				seq = strs[i + 1].length();
			}

		}
		return seq;
	}

	private static int findsubStr2(String string, String string2) {
		if (string.equals(string2)) {
			return -1;
		}
		if (string.length() > string2.length() && !string.contains(string2)) {
			return string.length();
		} else if (string.length() <= string2.length()
				&& !string2.contains(string)) {
			return string2.length();
		}
		return -1;
	}

	private static int findUncommonSubSeqlength(String string, String string2) {
		if (string.equals(string2))
			return -1;
		if (string.length() > string2.length()) {
			return string.length();
		} else {
			return string2.length();
		}
	}

	private static int findsubStr(String string, String string2) {
		if (string.equals(string2))
			return -1;
		int sz = string.length();
		if (string2.length() < sz) {
			sz = string2.length();
		}
		int lt = -1, rt = -1;
		if (string.length() > string2.length()) {
			if (!string.contains(string2))
				lt = string2.length();
		} else {
			if (!string2.contains(string)) {
				rt = string.length();
			}
		}
		if (lt > rt)
			sz = lt;
		else
			sz = rt;
		return sz;
	}

	public static int findlength(String a, String b) {
		if (a.equals(b))
			return -1;

		int index = 0;
		int b_len = b.length();
		int a_len = a.length();
		int lseq = a_len;
		int rseq = a_len;
		int seq = 0;
		boolean found = false;
		if (a_len <= b_len) {
			for (int i = a_len; i >= 0; i--) {
				String temp = a.substring(index, a_len);
				if (b.contains(temp)) {
					lseq--;
					found = true;
					break;
				}
				if (found)
					break;
				index++;

			}
			found = false;
			for (int i = a_len; i >= 0; i--) {
				String temp = a.substring(0, i);
				if (b.contains(temp)) {
					found = true;
					rseq--;
					break;
				}
				if (found)
					break;
			}
		} else if (b_len <= a_len) {
			seq = -1;

			/*
			 * if (lseq < rseq) { seq = rseq; }
			 */
			lseq = b_len;
			rseq = b_len;
			index = 0;
			found = false;
			for (int i1 = b_len; i1 >= 0; i1--) {
				String temp = b.substring(index, b_len);
				if (a.contains(temp)) {
					found = true;
					lseq--;
					break;
				}
				index++;

				if (found)
					break;
			}
			found = false;
			for (int i1 = b_len; i1 >= 0; i1--) {
				String temp = b.substring(0, i1);
				if (a.contains(temp)) {
					found = true;
					rseq--;
					break;
				}
				if (found)
					break;
			}
		}

		if (lseq < rseq) {
			if (seq < rseq)
				seq = rseq;
		} else {
			if (seq < lseq)
				seq = lseq;
		}

		return seq;
	}
}
