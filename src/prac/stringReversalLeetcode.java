package prac;

public class stringReversalLeetcode {

	public static void main(String[] args) {
		String str="Let's take LeetCode contest";
		System.out.println(reversal(str));
		System.out.println("s'teL ekat edoCteeL tsetnoc");
	}

	private static String reversal(String str) {
		int len = str.length();
		StringBuilder sb = new StringBuilder(len);
		String[] strArr = str.split(" ");
		for(int i=0;i<strArr.length;i++)
		{
			sb.append(reverse(strArr[i]) + " ");
		}
	
		return sb.toString().substring(0,sb.toString().length()-1);
	}

	private static String reverse(String string) {
		int len = string.length();
		StringBuilder sb = new StringBuilder(len);
		for(int i=len-1;i>=0;i--)
		{
			sb.append(string.charAt(i));
		}
		return sb.toString();
	}
}
