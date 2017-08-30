package prac;

public class CTCI_ch01_p3_StringManipulation {
	public static void main(String[] args) {
		System.out.println(replaceSpace("Mr John smith    "));
		System.out.println(replaceTheExisitingString("Mr John smith    "));
	}

	private static char[] replaceTheExisitingString(String string) {
		char[] chArr = string.toCharArray();
		return null;
	}

	private static String replaceSpace(String string) {
		char[] chArr = string.toCharArray();
		int len=string.length();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<len;i++)
		{
			if(chArr[i]==' ')
			{
				sb.append("%20");
				len=len-2;
			}			
			else
				sb.append(chArr[i]);
		}
		return sb.toString();
	}

}
