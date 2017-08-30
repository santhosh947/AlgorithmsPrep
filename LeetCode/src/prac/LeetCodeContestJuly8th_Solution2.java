package prac;
/**
 * https://leetcode.com/contest/leetcode-weekly-contest-40/problems/solve-the-equation/
 * @author SC043656
 *
 */

public class LeetCodeContestJuly8th_Solution2 {
	public static void main(String[] args) {
		String in1="x+5-3+x=6+x-2";
		String in2="x=x";
		String in3="2x=x";
		String in4="2x+3x-6x=x+2";
		String in5="x=x+2";
		System.out.println(solveEquation(in1));
	}

	private static String solveEquation(String in1) {
		String infi="Infinite solutions";
		String noSol = "No solution";
		
		String[] operands=in1.split("=");
		String left_red = minimize(operands[0]);
		
		return null;
	}

	private static String minimize(String str) {
		String res="";
		
		return res;
	}
}
