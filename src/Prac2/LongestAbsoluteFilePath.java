package Prac2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LongestAbsoluteFilePath {
	public static void main(String[] args) {
		String in1 = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		String in2 = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";

		System.out.println(lengthLongestPath(in1));
		// System.out.println(lengthLongestPath(in2));

	}

	public static int lengthLongestPath(String input) {
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(0); // "dummy" length
		int maxLen = 0;
		for (String s : input.split("\n")) {
			int lev = s.lastIndexOf("\t") + 1; // number of "\t"
			while (lev + 1 < stack.size()) {
				stack.pop(); // find parent
			}
			int len = stack.peek() + s.length() - lev + 1; // remove "/t",
															// add"/"
			stack.push(len);
			// check if it is file
			if (s.contains("."))
				maxLen = Math.max(maxLen, len - 1);
		}
		return maxLen;
	}

	public static int lengthLongestPath2(String input) {
		int maxLen = 0;
		if (input == null || input == "")
			return maxLen;

		Stack<String> st = new Stack<String>();
		StringBuilder wd = new StringBuilder();
		char ext = '.';
		String nextLine = "\\n";
		String tab = "\\t";
		char escChar = '\\';
		boolean isFile = false;
		int stagingCount = 0;
		boolean levelDecideMode = false;

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (!levelDecideMode && c == escChar) {
				levelDecideMode = true;
				break;
			}

			if (levelDecideMode) {

			}

			if (isFile) {
				stagingCount++;
				break;
			}

			if (isFile && c == escChar) {
				isFile = false;
				levelDecideMode = true;
				break;
			}

			if (c == ext) {
				isFile = true;
				break;
			}

		}
		return maxLen;
	}
}
