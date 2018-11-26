package prac;

public class CTCI_ch01_p5_StringManipulation {
public static void main(String[] args) {
	String str1="pale";
	String str2="pae";
	
	if(str1.length()==str2.length())
		System.out.println(AllCharsShouldMatch(str1,str2));
	else if((str2.length()-1==str1.length())||(str1.length()-1==str2.length()))
		System.out.println(shouldBeOnecharMisMatch(str1,str2));
	else
		System.out.println("false");
	
}

private static char[] shouldBeOnecharMisMatch(String str1, String str2) {
	// TODO Auto-generated method stub
	return null;
}

private static boolean AllCharsShouldMatch(String str1, String str2) {

	return true;
}
}
