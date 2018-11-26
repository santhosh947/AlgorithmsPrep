package prac;

public class wordReverse {

	public static void main(String[] args) {
		String str1 = "abcd";
		String str2 = "dcba";

		System.out.println(roundRotation(str1, str2));

	}

	private static int roundRotation(String str1, String str2) {
		if (str1.length() != str2.length())
			return -1;

		int i = 0, j = str1.length() - 1, k = 0, l = str2.length() - 1;

		do {
			boolean b1= str1.charAt(i) != str2.charAt(l);
			boolean b2=str1.charAt(j) != str2.charAt(k);
			if (b1 ||b2 ) {
				return -1;
			}
			i++;
			j--;
			k++;
			l--;
		} while (i < j + 1 && k < l + 1);

		return 1;
	}
}
