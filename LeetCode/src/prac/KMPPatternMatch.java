package prac;

public class KMPPatternMatch {
	public static void main(String[] args)
	{
		String text = "abxabcabcaby";
		String pattern = "abcadsfb";

		int[] lpsArray= buildLPS(pattern);

		System.out.println(checkIfPatternExisits(text,lpsArray,pattern));
	}

	public static boolean checkIfPatternExisits(String text,int[] lpsArray,String pattern)
	{
		int ind=0;
		for(int i=0;i<text.length();i++)
		{
			if(pattern.charAt(ind)==text.charAt(i))
			{
				ind++;
			}
			else
			{
				if(ind>0)
				{
					ind=lpsArray[ind-1]+1;
				}
			}
			if(ind==pattern.length())
				return true;
			
		}
		return false;
	}

	public static int[] buildLPS(String pattern)
	{
		int[] result = new int[pattern.length()];
		if(pattern.length()==0)
		{
			return result;
		}
		else
		{
			int i=1;
			int j=i-1;
			for(i=1;i<pattern.length();i++)
			{
				if(pattern.charAt(j)==pattern.charAt(i))
				{
					result[i]=j+1;
					j++;
				}
				else
				{
					if(j>0)
					{
						j=result[j-1];
					}
				}
			}
		}
		return result;
	}
}
