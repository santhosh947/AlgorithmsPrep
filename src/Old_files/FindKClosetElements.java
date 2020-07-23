package Old_files;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/contest/leetcode-weekly-contest-45/problems/find-k-closest-elements/
 * @author santh
 *
 */
public class FindKClosetElements {
	public static void main(String[] args) {
	//	int[] arr= {1,2,3,4,5};
		List<Integer> arr= new ArrayList<>();
		arr.add(0);
		arr.add(0);
		arr.add(1);
		arr.add(4);
		arr.add(5);

		List<Integer> res = findClosestElements(arr, 4, 3);
		for(int i: res)
		{
			System.out.println(i);
		}
	}
	public static List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        List<Integer> res = new ArrayList<Integer>();
        if(arr==null)
            return res;
        int end=arr.size();
        if(x<arr.get(0))
        {
            for(int i=0;i<k;i++)
            {
                res.add(arr.get(i));
            }
            return res;
        }
        if(x>arr.get(end-1))
        {
            for(int i=end-1;i>end-1-k;i--)
            {
                res.add(arr.get(i));
            }
            return res;
        }
        int cnt=k;
        int p=-1;
        for(int i=0;i<end;i++)
        {
            if(arr.get(i)>=x)
            {
                res.add(arr.get(i));
                cnt--;
                p=i;
                break;
            }
        }
        int s=p-1,t=p+1;
        while(s>=0 && t<end && cnt>0)
        {
        	res.add(arr.get(s));
        	cnt--;
        	s--;
        	if(cnt>0)
        	{
        		res.add(arr.get(t));
        		t++;
        		cnt--;
        	}
        }
        while(cnt>0 && s>=0)
        {
        	res.add(arr.get(s));
        	cnt--;
        	s--;
        }
        

        while(cnt>0 && t<end)
        {
        	res.add(arr.get(t));
        	cnt--;
        	t++;
        }
        Collections.sort(res);
        return res;
        
    }
}
