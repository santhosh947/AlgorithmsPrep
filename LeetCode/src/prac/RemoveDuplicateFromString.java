package prac;

public class RemoveDuplicateFromString {

	public static void main(String[] args) {
		
		String str="samad";
		System.out.println(RemoveDuplicate(str));
		
	}

	private static String RemoveDuplicate(String str) {
		String op="";
		boolean[] ch = new boolean[256];
		for(int i=0;i<str.length();i++)
		{
			int id = str.charAt(i);
			if(!ch[id])
				op+=str.charAt(i);
			ch[id]=true;
		}
		return op;
	}

}
