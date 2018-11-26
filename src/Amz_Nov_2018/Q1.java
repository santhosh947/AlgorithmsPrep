package Amz_Nov_2018;

import java.util.ArrayList;
import java.util.List;

public class Q1 {

	public static void main(String[] args) {

		int[] i1 = { 1, 0, 0, 0, 0, 1, 0, 0 };
		int[] i2 = { 1, 1, 1, 0, 1, 1, 1, 1 };
		List<Integer> r1 = cellCompete(i1, 1);
		List<Integer> r2 = cellCompete(i2, 2);

		for (int i = 0; i < r1.size(); i++) {
			System.out.print(r1.get(i) + ",");
		}
		System.out.println();
		for (int i = 0; i < r2.size(); i++) {
			System.out.print(r2.get(i) + ",");
		}

	}

	public static List<Integer> cellCompete(int[] states, int days) {
		List<Integer> res = new ArrayList<Integer>();
		//int[] stage = states;
		for (int a : states) {
			res.add(a);
		}
		for (int i = 0; i < days; i++) {
			for (int j = 0; j < res.size() - 1; j++) {
				if (j == 0) {
					if (res.get(j + 1) == 0)
						states[j] = 0;
					else
						states[j] = 1;
				} 
				if (j == res.size() - 2) {
					if (res.get(j) == 0)
						states[j + 1] = 0;
					else
						states[j + 1] = 1;
				} 
				if(j!=0)
				{
					if (res.get(j - 1) == res.get(j + 1))
						states[j] = 0;
					else
						states[j] = 1;
				}
			}
			res = new ArrayList<Integer>();
			for (int h : states) {
				res.add(h);
			}
		}
		
		return res;
		// WRITE YOUR CODE HERE
	}
}
