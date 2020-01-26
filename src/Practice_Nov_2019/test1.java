package Practice_Nov_2019;

import java.util.*;
public class test1 {

	public static void main(String[] args) {

		Map<Integer,Integer> hm = new HashMap();
		
		hm.put(0,100);
		System.out.println(hm.getOrDefault(hm.get(0),2));
		
	}

}
