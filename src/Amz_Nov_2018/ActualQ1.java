package Amz_Nov_2018;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class ActualQ1 {
	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(-3);

		List<Integer> l2 = new ArrayList<>();
		l2.add(1);
		l2.add(2);

		List<Integer> l3 = new ArrayList<>();
		l3.add(3);
		l3.add(4);

		List<Integer> l4 = new ArrayList<>();
		l4.add(-1);
		l4.add(3);

		List<List<Integer>> allLocations = new ArrayList<List<Integer>>();

		allLocations.add(l1);
		allLocations.add(l2);
		allLocations.add(l3);
		allLocations.add(l4);

		List<List<Integer>> nearBy = nearestXsteakHouses(4, allLocations, 2);
		for (List<Integer> loc : nearBy) {
			System.out.print(loc.get(0) + "," + loc.get(1));
			System.out.println();
		}
		
		System.out.println("******************************************");
		
		List<List<Integer>> nearBy2 = nearestKPoints(4, allLocations, 2);
		for (List<Integer> loc : nearBy2) {
			System.out.print(loc.get(0) + "," + loc.get(1));
			System.out.println();
		}
	}

	public static int findDistance(int x, int y) {
		return x * x + y * y;
	}

	public static List<List<Integer>> nearestKPoints(int totalSteakhouses,
			List<List<Integer>> allLocations, int numSteakhouses) {
		if (numSteakhouses > totalSteakhouses)
			return allLocations;
		if (numSteakhouses == 0 || totalSteakhouses == 0)
			return null;

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		int[] dis = new int[allLocations.size()];

		for (int i = 0; i < allLocations.size(); i++) {
			dis[i] = findDistance(allLocations.get(i).get(0),
					allLocations.get(i).get(1));
		}
		
		Arrays.sort(dis);
		Set<Integer> tempHs = new HashSet<Integer>();
		
		for(int i=0;i< numSteakhouses; i++)
		{
			tempHs.add(dis[i]);
		}
		
		int tempCt = numSteakhouses;
		
		for (int i = 0; i < allLocations.size() && tempCt!=0 ; i++) {
			int dist = findDistance(allLocations.get(i).get(0),
					allLocations.get(i).get(1));
			if(tempHs.contains(dist))
			{
				List<Integer> l1 = new ArrayList<>();
				l1.add((int) allLocations.get(i).get(0));
				l1.add((int) allLocations.get(i).get(1));
				result.add(l1);
				tempCt--;
			}
		}
	
		return result;
	}

	/**
	 * The Method checks for the edge cases such as when the numSteakHouses is
	 * greater than the totalSteakhouses and when the numSteakHouses or
	 * totalSteakhouses are zero
	 * 
	 * We are converting the locations into Point which contains the x and y
	 * coordinates. And we are creating a Max-Heap of size numSteakHouses and as
	 * we iterate through every coordinate, we check if the distance of the new
	 * coordinate is less than or equal to the already existing coordinate in
	 * the priority queue and if the new coordinate is closer to the origin we
	 * replace with less priority value from the queue.
	 * 
	 * We are using the reverseorder() to maintain the priority queue in the
	 * descending order of the distance of the point from origin.
	 * 
	 * At the end the Priority queue only contains K coordinates which are
	 * closer to the origin.
	 * 
	 */
	public static List<List<Integer>> nearestXsteakHouses(int totalSteakhouses,
			List<List<Integer>> allLocations, int numSteakhouses) {
		if (numSteakhouses > totalSteakhouses)
			return allLocations;
		if (numSteakhouses == 0 || totalSteakhouses == 0)
			return null;

		Map<Point, List<Integer>> hm = new HashMap<Point, List<Integer>>();

		for (int i = 0; i < allLocations.size(); i++) {
			Point p = new Point(allLocations.get(i).get(0), allLocations.get(i)
					.get(1));
			hm.put(p, allLocations.get(i));
		}

		Point[] pts = new Point[hm.size()];
		int i = 0;
		for (Point p : hm.keySet()) {
			pts[i] = p;
			i++;
		}

		Point[] res = findClosetKPoints(pts, numSteakhouses);

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for (int j = 0; j < res.length; j++) {
			List<Integer> l1 = new ArrayList<>();
			l1.add((int) res[j].x);
			l1.add((int) res[j].y);
			result.add(l1);
		}

		return result;
	}

	public static class Point implements Comparable<Point> {
		public double x;
		public double y;

		public Point(double xcor, double ycor) {
			this.x = xcor;
			this.y = ycor;
		}

		public double findDist() {
			return x * x + y * y;
		}

		@Override
		public int compareTo(Point o) {

			int c = Double.compare(findDist(), o.findDist());
			if (c == 0) {
				c = Double.compare(x, o.x);
				if (c == 0) {
					c = Double.compare(y, o.y);
				}
			}
			return c;
		}

		public String toString() {
			return "(" + x + "," + y + ")";
		}

	}

	public static Point[] findClosetKPoints(final Point points[], final int k) {
		// max heap
		final PriorityQueue<Point> kClosest = new PriorityQueue<>(k,
				Collections.reverseOrder());

		for (int i = 0; i < points.length; i++) {
			if (kClosest.size() < k) {
				kClosest.add(points[i]);
			} else if (points[i].findDist() < kClosest.peek().findDist()) {
				kClosest.remove();
				kClosest.add(points[i]);
			}
		}

		return kClosest.toArray(new Point[k]);
	}

	// private List<Point> nearestPoint(List<Point> list, )

}
