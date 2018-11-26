import java.util.HashMap;
import java.util.Map;

/**
 * https://www.careercup.com/question?id=5768946767626240
 * @author santh
 *
 */
public class RemovingOneStringFromAnother {
	public static void main(String[] args) {
		System.out.println(RemoveString("A Statement is a Statement","Statement a"));
	}
	public static String RemoveString(String s1, String s2)
	{
		StringBuilder res=new StringBuilder();
		String[] s1Arr=s1.split(" ");
		String[] s2Arr=s2.split(" ");
		Map<String, Boolean> hm=new HashMap<String, Boolean>();
		
		for(int i=0;i<s2Arr.length;i++)
		{
			if(!hm.containsKey(s2Arr[i]))
				hm.put(s2Arr[i], true);
			
		}
		
		for(int i=0;i<s1Arr.length;i++)
		{
			if(hm.containsKey(s1Arr[i]) && hm.get(s1Arr[i]))
			{
				hm.put(s1Arr[i], false);
			}
			else
			{
				res.append(s1Arr[i]);
				res.append(" ");
			}
		}
		String res1=res.toString();
		res1=res1.substring(0, res.length()-1);
		return res1;
	}
}
