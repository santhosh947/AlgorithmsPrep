// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class FindMClosestPointsFromOriginFromAGivenList {
	public static void main(String[] args) {
		List<List<Integer>> in = new ArrayList<>();
		List<Integer> i1 = new ArrayList<>();
		i1.add(1);
		i1.add(2);

		in.add(i1);

		List<Integer> i2 = new ArrayList<>();
		i2.add(3);
		i2.add(4);

		in.add(i2);

		List<Integer> i3 = new ArrayList<>();
		i3.add(1);
		i3.add(-1);

		in.add(i3);

		List<List<Integer>> res = closestLocations(3, in, 2);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i).get(0) + " ");
			System.out.print(res.get(i).get(1));
			System.out.println();

		}
	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static List<List<Integer>> closestLocations(int totalCrates, List<List<Integer>> allLocations,
			int truckCapacity) {
		if (allLocations == null) {
			return null;
		}
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> trunctLoc = new ArrayList<>();
		trunctLoc.add(0);
		trunctLoc.add(0);
		Map<Double, List<Integer>> hm = new HashMap<Double, List<Integer>>();
		double[] d = new double[allLocations.size()];

		for (int i = 0; i < allLocations.size(); i++) {
			int x = allLocations.get(i).get(0);
			int y = allLocations.get(i).get(1);
			double dist = Math.sqrt(x * x + y * y);

			hm.put(dist, allLocations.get(i));
			d[i] = dist;
		}

		Arrays.sort(d);

		for (int i = 0; i < truckCapacity; i++) {
			res.add(hm.get(d[i]));
		}
		return res;

	}
	// METHOD SIGNATURE ENDS
}