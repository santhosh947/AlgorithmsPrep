package prac;

public class StringRemoval {

	public static void main(String[] args) {

		String s1 = "A Statement is a Statement";
		String s2 = "Statement a";
		String ss = null;
		String[] arr1 = s2.split("\\s");
		String[] arr2 = s1.split("\\s");

		int flag = -1;

		for (int i = 0; i < arr1.length; i++) {

			for (int j = 0; j < arr2.length; j++) {

				flag = arr2[j].compareTo(arr1[i]);

				if (flag == 0) {
					ss = s1.replaceFirst(arr2[j], "");
					s1 = ss;

					break;
				}
			}

		}
		System.out.println(s1);

	}

}
