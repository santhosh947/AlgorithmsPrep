package Prac2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TelephoneKeypad {
	public static void main(String[] args) {
	     /* long startTime = System.currentTimeMillis();

		List<String> res = letterCombinations("2345678923456");
		long stopTime = System.currentTimeMillis();
	      long elapsedTime = stopTime - startTime;
	      System.out.println(elapsedTime);*/
	      
	      long startTime2 = System.currentTimeMillis();

			List<String> res2 = letterCombinations2("23");
			long stopTime2 = System.currentTimeMillis();
		      long elapsedTime2 = stopTime2 - startTime2;
		      System.out.println(elapsedTime2);
		/*for (String s : res) {
			System.out.print(s + ",");
		}*/

	}
	
	public static List<String> letterCombinations2(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		while(ans.peek().length()!=digits.length()){
			String remove = ans.remove();
			String map = mapping[digits.charAt(remove.length())-'0'];
			for(char c: map.toCharArray()){
				ans.addLast(remove+c);
			}
		}
		return ans;
	}

	public static List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		Map<Integer, String> lookUp = new HashMap<Integer, String>();
		lookUp.put(2, "abc");
		lookUp.put(3, "def");
		lookUp.put(4, "ghi");
		lookUp.put(5, "jkl");
		lookUp.put(6, "mno");
		lookUp.put(7, "pqrs");
		lookUp.put(8, "tuv");
		lookUp.put(9, "wxyz");
		for (int i = 0; i < digits.length(); i++) {
			int d = Character.getNumericValue(digits.charAt(i));
			char[] ch = lookUp.get(d).toCharArray();
			for (int j = 0; j < ch.length; j++) {
				if (i == 0) {
					res.add(String.valueOf(ch[j]));
				} else {
					for (int k = 0; k < res.size(); k++) {
						String st = res.get(k);
						//if (st.length() == i-1) {
						//	res.remove(st);
						//}
						if (st.length() == i) {
							res.add(st + String.valueOf(ch[j]));
						}
					}
				}
			}
		}
		
		List<String> op = new ArrayList<String>();
		for(int i=0;i<res.size();i++)
		{
			if(res.get(i).length()==digits.length())
				op.add(res.get(i));
		}
			
		return op;
	}
}
