package prac;

import java.util.HashMap;
import java.util.Map;

public class Test
{
	public static void main(String[] args) {
		Map<Integer, String> hm = new HashMap<>();
		hm.put(1, "sam");
		hm.put(2, "ad");
		for(int i: hm.keySet())
		{
			System.out.println("Key " + i);
			System.out.println("Value " + hm.get(i));
		}
		
	}

	public static void doi(int i, int j, int k) {
		// TODO Auto-generated method stub
		
	}
	
}