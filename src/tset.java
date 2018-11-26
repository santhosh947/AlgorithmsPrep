import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tset {
	public static void main(String[] args) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> r1= new ArrayList<>();
		r1.add(1);
		res.add(r1);
        Map<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();

		System.out.println(Math.sqrt(1*1+2*2));
	
		double[] d = new double[3];
		d[0]=9.555858585;
		d[1]=10.1231231;
		d[2]=10.132323;
		
		Arrays.sort(d);
		for(double dd: d)
		{
			System.out.println(dd);
		}
	}
}
