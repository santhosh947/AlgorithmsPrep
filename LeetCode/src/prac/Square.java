package prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//DIG
public class Square {

	static class coordinate {
		int x;
		int y;

		coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		String[] points = null;
		while ((s = in.readLine()) != null) {
			points = s.split(", ");

			coordinate p1 = null;
			List<coordinate> coordinates = new ArrayList<coordinate>();

			int x = 0, y = 0;
			for (String point : points) {
				String[] coord = point.split(",");
				x = Integer.parseInt(coord[0].substring(1));
				y = Integer.parseInt(coord[1].substring(0,
						coord[1].length() - 1));
				p1 = new coordinate(x, y);
				coordinates.add(p1);
			}

			System.out.println(isSquare(coordinates));
		}
	}

	private static boolean isSquare(List<coordinate> coordinates) {
		double d2 = findDist(coordinates.get(0), coordinates.get(1)); // From P1 to P2
		double d3 = findDist(coordinates.get(0), coordinates.get(2)); // From P1 to P3
		double d4 = findDist(coordinates.get(0), coordinates.get(3)); // From P1 to P4

		if ((d2 == d3) && 2 * d2 == d4) {
			double d = findDist(coordinates.get(1), coordinates.get(3));
			return (d == findDist(coordinates.get(2), coordinates.get(3)) && d == d2);
		}

		if ((d3 == d4) && 2 * d3 == d2) {
			double d = findDist(coordinates.get(1), coordinates.get(2));
			return (d == findDist(coordinates.get(1), coordinates.get(3)) && d == d3);
		}

		if ((d2 == d4) && 2 * d2 == d3) {
			double d = findDist(coordinates.get(1), coordinates.get(2));
			return (d == findDist(coordinates.get(2), coordinates.get(3)) && d == d2);
		}
		return false;
	}

	private static double findDist(coordinate c1, coordinate c2) {
		double dist = 0;
		dist = ((c2.x - c1.x) * (c2.x - c1.x)) + ((c2.y - c1.y) * (c2.y - c1.y));
		return dist;
	}
}
