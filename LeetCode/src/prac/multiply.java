package prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class multiply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int inp = 13;
		
		System.out.println("Least number : " + multiply(inp));

	}
	
	public static String multiply(int in)
	{
		String res="";
		int div=9;
		List<Integer> divisors= new ArrayList<>();
		int remainder=0;
		
		for (;div>1;div--)
		{
			if(in % div ==0)
			{
				in = in/div;
				divisors.add(div);
				div++;
			}			
		}
		Collections.reverse(divisors);
		for(int d = 0;d<divisors.size();d++)
		{
			res+=divisors.get(d);
		}
		return res;
	}

}
