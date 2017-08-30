package prac;

public class MS {
	public static void main(String[] args) {
	//	System.out.println(removeKdigits("4205123", 4));
		System.out.println(removeKdigits("216504", 3));
		String[] s = new String[2];
		s[0]="6092162204";
		s[1]="609-216-2204";
		for(String ss: s)
		{
			System.out.println(ss);
		}
		Reformat(s);
		for(String ss: s)
		{
			System.out.println(ss);
		}
	}
	
	public static void Reformat(String[] phoneNumbers){
		for( int i = 0; i < phoneNumbers.length; i++)
		{
	    	String phoneNumber = phoneNumbers[i];
	    	phoneNumber = phoneNumber.replace("-","");
	    	String temp= phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(0,3) + "-" + phoneNumber.substring(6,10);
	    	phoneNumbers[i] = temp;

		}

		/*for( int i = 0; i < phoneNumbers.length - 1; i++)
		{
	    	StringBuilder phoneNum = new StringBuilder(phoneNumbers[i]);
	    	phoneNumber = phoneNum.replace("-","");
	    	String temp= phoneNumb.substring(3, 5)
	    			+”-”+phoneNumber.substring(0, 2)+”-”+phoneNumber.substring(6, 9);
	    	phoneNumbers[i] = temp;

		}*/

	}

	
	public static String removeKdigits(String num, int k) {
        int digits = num.length() - k;
        char[] stk = new char[num.length()];
        int top = 0;
        // k keeps track of how many characters we can remove
        // if the previous character in stk is larger than the current one
        // then removing it will get a smaller number
        // but we can only do so when k is larger than 0
        for (int i = 0; i < num.length(); ++i) {
            char c = num.charAt(i);
            while (top > 0 && stk[top-1] > c && k > 0) {
                top -= 1;
                k -= 1;
            }
            stk[top++] = c;
        }
        // find the index of first non-zero digit
        int idx = 0;
        while (idx < digits && stk[idx] == '0') idx++;
        return idx == digits? "0": new String(stk, idx, digits - idx);
    }
}
