package Old_files;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class MergeIntervals_Expedia {
	public static void main(String[] args) {
		Interval i1= new Interval(1,3);
		Interval i2= new Interval(2,6);
		Interval i3= new Interval(8,10);
		Interval i4= new Interval(15,18);
		
		List<Interval>  l = new ArrayList<>();
		l.add(i1);
		l.add(i3);
		l.add(i2);
		l.add(i4);
		
		List<Interval> re= merge(l);
		for(Interval ll : re)
		{
			System.out.println(ll.start + " " + ll.end);
		}
	}
	public static List<Interval> merge(List<Interval> intervals) {
		// sort start&end
		int n = intervals.size();
		int[] starts = new int[n];
		int[] ends = new int[n];
		for (int i = 0; i < n; i++) {
			starts[i] = intervals.get(i).start;
			ends[i] = intervals.get(i).end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		// loop through
		List<Interval> res = new ArrayList<Interval>();
		for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
			if (i == n - 1 || starts[i + 1] > ends[i]) {
				res.add(new Interval(starts[j], ends[i]));
				j = i + 1;
			}
		}
		return res;
	}
}
