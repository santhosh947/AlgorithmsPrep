package Old_files;
import java.util.HashMap;
import java.util.Map;

public class RansomNote {
	public static void main(String[] args) {
		System.out.println(canConstruct2("aa", "ab"));
	}
	
	public static boolean canConstruct2(String ransomNote, String magazine) {
		int[] availableChars = new int[26];
		
		for(int i=0;i<magazine.length();i++)
		{
			char c=magazine.charAt(i);
			availableChars[c-'a']++;
		}
		
		for(int i=0;i<ransomNote.length();i++)
		{
			char c=ransomNote.charAt(i);
			if(availableChars[c-'a']<=0)
				return false;
			else
				availableChars[c-'a']--;
		}
		
		return true;
	}
	
		public static boolean canConstruct(String ransomNote, String magazine) {
			if (magazine == null)
				return false;
	
			Map<Character, Integer> hm = new HashMap<Character, Integer>();
			for (int i=0; i < ransomNote.length(); i++) {
				char c = ransomNote.charAt(i);
				if (hm.containsKey(c)) {
					hm.put(c, hm.get(c) + 1);
				} else {
					hm.put(c, 1);
				}
			}
	
			for (int i = 0; i < magazine.length(); i++) {
				char c = magazine.charAt(i);
				if (hm == null)
					return true;
	
				if (hm.size() == 0)
					return true;
				if (hm.containsKey(c)) {
					if (hm.get(c) == 1)
						hm.remove(c);
					else
						hm.put(c, hm.get(c) - 1);
				}
			}
			
			if (hm == null)
				return true;
	
			if (hm.size() == 0)
				return true;
	
			return false;
		}

}
