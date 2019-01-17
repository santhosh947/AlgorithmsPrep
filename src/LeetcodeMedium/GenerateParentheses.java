package LeetcodeMedium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GenerateParentheses {
	public static void main(String[] args) {
	    List<String> strings =  generateParenthesis3(2);
	    
	    for (String string : strings) {
	      System.out.println(string);
	    }
	  }
	
	 public static List<String> generateParenthesis3(int n)
	    {
	        List<List<String>> lists = new ArrayList<>();
	        lists.add(Collections.singletonList(""));
	        
	        for (int i = 1; i <= n; ++i)
	        {
	            final List<String> list = new ArrayList<>();
	            
	            for (int j = 0; j < i; ++j)
	            {
	                for (final String first : lists.get(j))
	                {
	                    for (final String second : lists.get(i - 1 - j))
	                    {
	                        list.add("(" + first + ")" + second);
	                    }
	                }
	            }
	            
	            lists.add(list);
	        }
	        
	        return lists.get(lists.size() - 1);
	    }
	
	public static List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public static void backtrack(List<String> list, String str, int open, int close, int max){
        
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
	  
	  public static List<String> generateParenthesis(int n)
	  {
	    LinkedList<String> res = new LinkedList<String>();
	    Set<String> hs = new HashSet<String>();
	    res.add("");
	    for(int i=1;i<=n;i++)
	    {
	      while(res.size()>0 && res.peek().length()!=n*2)
	      {
	        String top = res.poll();
	        //Surrond
	        String nwStr = "(" + top + ")";
	        if(nwStr.length()==n*2)
	          hs.add(nwStr);
	        
	        res.add(nwStr);
	        String nwStr1 = "()" + top;
	        if(nwStr1.length()==n*2)
	          hs.add(nwStr1);
	        
	        
	        String nwStr2 = top+"()";
	        if(nwStr2.length()==n*2)
	          hs.add(nwStr2);
	        
	        if(nwStr1.equals(nwStr2))
	          res.add(nwStr1);
	        else
	        {
	          res.add(nwStr1);
	          res.add(nwStr2);
	        }       
	      }
	    }
	    res = new LinkedList<String>();
	    for(String s: hs)
	    	res.add(s);
	    return res;
	  }
}
