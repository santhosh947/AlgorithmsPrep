package prac;

public class longestPalindrome {

	public static void main(String[] args) {
		System.out.println(longestPalindrome2("babad"));
		
	}
	static int lo;
	static int max;
	public static String longestPalindrome2(String s)
	{
		if(s.length()<2)
			return s;
		int len=s.length();
		for (int i = 0; i < len-1; i++) {
			//System.out.println(i);
	     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
	     	extendPalindrome(s, i, i+1); //assume even length.
	    }
		return s.substring(lo,lo+max);
	}
	private static void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (max < k - j - 1) {
			lo = j + 1;
			max = k - j - 1;
		}
	}

}
