package prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class uniqueWords {
 public static void main(String[] args) {
	String str= "sam ha sam raj";
	List<String> ls= findUniqueWords(str);
	for(String s:ls)
	{
		System.out.println(s);
	}
}
 
 static List<String> findUniqueWords(String str)
 {

 	String[] names = str.split("\\s");
 	Map<String,Integer> hm = new HashMap<String,Integer>();
 	for(String s:names)
 	{
 	   if(hm.get(s)!=null)
 	   {
 			hm.put(s,hm.get(s)+1);
 	   }
 	   else
 	   {
 		hm.put(s,1);
 	   }
 	}
 	
 	List<String> result = new ArrayList();
 	Iterator entries = hm.entrySet().iterator();

 	while(entries.hasNext())
 	{
 		Map.Entry entry = (Map.Entry) entries.next();
 	    String key = (String)entry.getKey();
 	    Integer value = (Integer)entry.getValue();
 		if(value==1)
 			result.add(key);
 	}
 	
 	return result;
 }
}
