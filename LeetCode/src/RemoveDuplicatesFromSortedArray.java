import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		int[] nums = { 4, 5, 5, 1, 1, 2, 3, 4 };
		for (int i : nums) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		/*List<Integer> r= new ArrayList<Integer>();
		r.add(1);
		r.add(2);
		r.add(3);
		for(int i=0;i<r.size();i++)
		{
			System.out.println(r.get(i));
		}
		*/
		
		int[] res=removeDups(nums);

		System.out.println();
		for (int i : res) {
			System.out.print(i + " ");
		}
	}

	public static int[] removeDups(int[] nums) {
		Map<Integer,Boolean> hm = new HashMap<Integer, Boolean>();
		List<Integer> l= new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++)
		{
			if(!hm.containsKey(nums[i]))
			{
				l.add(nums[i]);
				hm.put(nums[i], true);
			}
		}
		int[] res= new int[l.size()];
		for(int i=0;i<l.size();i++)
		{
			res[i]=l.get(i);
		}
		return res;
	}
}
