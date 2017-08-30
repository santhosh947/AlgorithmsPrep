package prac;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class lgst {
	String pr;
	int t;
	String msg;

	lgst(String lg, String msg, int lg2) {
		this.pr = lg;
		this.msg = msg;
		this.t = lg2;
	}
}

public class LeetcodeDt715Log {
	public static void main(String[] args) {
		int[] a = { -1 };
		List<String> in = new ArrayList<>();
		/*in.add("0:start:0");
		in.add("0:start:2");
		in.add("0:end:5");
		in.add("0:start:6");
		in.add("0:end:6");
		in.add("0:end:7");
*/
		in.add("0:start:0");
		in.add("1:start:2");
		in.add("1:end:5");
		in.add("0:end:6");
		int[] res = exclusiveTime(2, in);
		for (int i : res) {
			System.out.println(i);
		}
	}

	public static int[] exclusiveTime1(int n, List<String> logs) {
		int[] res = new int[n];
		Stack<lgst> st = new Stack<>();
		int pt = 0;
		int ct = 0;
		String pp = null;
		String cp = null;
		for (int i = 0; i < logs.size(); i++) {
			String[] lg = logs.get(i).split(":");
			String ttpp="";
			if (st.size() > 0) {
				//System.out.println(st.size());
				//System.out.println(st.peek().pr);
				ttpp=st.peek().pr;

			}
			if (st.size() > 0 && ttpp.equals(lg[0])) {
				lgst lgTemp = st.pop();

				int temp = Integer.parseInt(lg[0]);
				ct = Integer.parseInt(lg[2]);
				res[temp] += ct - pt;
				pt = ct;
			} else {
				ct = Integer.parseInt(lg[2]);
				lgst lgTemp2 = new lgst(lg[0], lg[1], ct);
				cp = lg[0];
				if (cp != pp && pp != null) {
					res[Integer.parseInt(cp)] += 1;
					res[Integer.parseInt(pp)] += ct - pt;
				}
				st.push(lgTemp2);
				pp = cp;
				pt = ct;
			}
		}
		return res;
	}
	
	public static int[] exclusiveTime(int n, List<String> logs) {
	    int[] res = new int[n];
	    Stack<Integer> stack = new Stack<>();
	    int prevTime = 0;
	    for (String log : logs) {
	        String[] parts = log.split(":");
	        if (parts[1].equals("start")) {
	            if (!stack.isEmpty()) res[stack.peek()] +=  Integer.parseInt(parts[2]) - prevTime; 
	            stack.push(Integer.parseInt(parts[0]));
	            prevTime = Integer.parseInt(parts[2]);
	        }
	        else {
	            res[stack.pop()] += 1 + Integer.parseInt(parts[2]) - prevTime;
	            prevTime = 1 + Integer.parseInt(parts[2]);
	        }
	    }
	    return res;
	}

}
