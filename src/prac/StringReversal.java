package prac;

public class StringReversal {

	public static void main(String[] args) {
		String str = "the sky is blue";
		System.out.println(reverseWord(str));
		System.out.println(Reverse(str));
	}

	private static String Reverse(String str) {
		StringBuilder reversedStr = new StringBuilder(str.length());
		int wordStart = 0;
		int wordEnd = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				wordEnd = i;
				reversedStr.append(reverseWord(str.substring(wordStart, wordEnd))+ " ");
				wordStart=i;
			} /*else {
				wordStart = i;
			}*/
		}
		return reversedStr.toString();
	}

	public static String reverseWord(String str) {
		String op = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			op += str.charAt(i);
		}
		return op;
	}
}
