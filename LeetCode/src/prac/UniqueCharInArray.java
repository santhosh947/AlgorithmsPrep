package prac;

public class UniqueCharInArray {

	public static void main(String[] args) {

		String str = "samm";
		System.out.println(havingUniqueChars(str));
	}

	private static boolean havingUniqueChars(String str) {
		boolean[] ch= new boolean[256];
		for(int i=0;i<str.length();i++)
		{
			int id = str.charAt(i);
			if(ch[id]) 
				return false;
			ch[id]=true;
			
		}
		return true;
	}

}
