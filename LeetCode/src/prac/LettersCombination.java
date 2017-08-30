package prac;

import java.util.LinkedList;
import java.util.List;

public class LettersCombination {
	public static void main(String[] args) {
		List<String> res=letterCombinations("234");
		for(String s: res)
		{
			System.out.println(s);
		}
	}
	
	public static List<String> letterCombinations(String digits) {
	    LinkedList<String> ans = new LinkedList<String>();
	    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	    ans.add("");
	    for(int i =0; i<digits.length();i++){
	        int x = Character.getNumericValue(digits.charAt(i));
	        while(ans.peek().length()==i){
	            String t = ans.remove();
	            for(char s : mapping[x].toCharArray())
	                ans.add(t+s);
	        }
	    }
	    return ans;
	}

}
