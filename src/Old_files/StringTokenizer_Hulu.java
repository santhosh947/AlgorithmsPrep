package Old_files;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StringTokenizer_Hulu {

	// Class name must be "Main"
	// Libraries included:
	// json simple, guava, apache commons lang3, junit, jmock

	public static void main(String[] args) {
		String s = "abc(edf)hij{klmn}opq[rst]uvw"; //op: ["abc", "edf", "hij", "klmn", "opq", "rst", "uvw"]

		String s1 = "abc(e))df)";//op:  ["abc", "e)df"]
		
		String s2="abc(e{df}}g)"; //op: ["abc", "e{df}}g"]

		//List<String> res = findListOfStrings(s1);
		String[] r = extractSubstrings(s1);

		for (String ss : r) {
			System.out.println(ss);
		}
	}
	
	//Correct
	public static String[] extractSubstrings(String str) {
		ArrayList<String> list = new ArrayList<String>();
		StringBuffer buffer = new StringBuffer();
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(' || c == ')') {
				if (c == '(' && str.charAt(i + 1) == '(') {
					buffer.append(String.valueOf(c));
					st.push(')');
					i++;
				} else if (c == ')' && i + 1 < str.length() && str.charAt(i + 1) == ')') {
					buffer.append(String.valueOf(c));
					i++;
				} 
				else if (buffer.length() > 0) {
					list.add(buffer.toString());
					buffer = new StringBuffer();
					if (c==')') {
						if(st.size()>0 && st.peek()=='(')
							st.pop();
					}
					else if (c=='(') {
						st.push('(');
					}
				}
			} else if (c == '{' || c == '}') {
				if (c == '{' && str.charAt(i + 1) == '{') {
					buffer.append(String.valueOf(c));
					i++;
				} else if (c == '}' && i + 1 < str.length() && str.charAt(i + 1) == '}') {
					buffer.append(String.valueOf(c));
					i++;
				} else if(st.size()>0 && st.peek()=='(' && (c=='{' || c=='}') ) {
					buffer.append(String.valueOf(c));
					i++;
				}
				else if (buffer.length() > 0) {
					list.add(buffer.toString());
					buffer = new StringBuffer();
				}
			} else if (c == '[' || c == ']') {
				if (c == '[' && str.charAt(i + 1) == '[') {
					buffer.append(String.valueOf(c));
					i++;
				} else if (c == ']' && i + 1 < str.length() && str.charAt(i + 1) == ']') {
					buffer.append(String.valueOf(c));
					i++;
				} else if (buffer.length() > 0) {
					list.add(buffer.toString());
					buffer = new StringBuffer();
				}
			} else {
				buffer.append(String.valueOf(c));
			}
		}

		if (buffer.length() > 0) {
			list.add(buffer.toString());
		}

		return list.toArray(new String[0]);
	}

	public static List<String> findListOfStrings(String s) {

		List<String> res = new ArrayList<String>();
		if (s == null)
			return res;

		StringBuilder a = new StringBuilder();
		for (int i = 0; i < s.length() - 1; i++) {
			Character c1 = s.charAt(i);
			Character c2 = s.charAt(i + 1);
			if (c1 == '(' && c2 != ')') {
				if (a.toString().length() > 0) {
					res.add(a.toString());
					a = new StringBuilder();
				}
				// a.append(c2);
			} else if (c1 == ')' && c2 != '(') {
				// a.append(c2);
				res.add(a.toString());
				a = new StringBuilder();
			}

			else if (c1 == '{' && c2 != '}') {
				if (a.toString().length() > 0) {
					res.add(a.toString());
					a = new StringBuilder();
				}
				// a.append(c2);
			} else if (c1 == '}' && c2 != '{') {
				// a.append(c2);
				res.add(a.toString());
				a = new StringBuilder();
			}

			else if (c1 == '[' && c2 != ']') {
				if (a.toString().length() > 0) {
					res.add(a.toString());
					a = new StringBuilder();
				}
				// a.append(c2);
			} else if (c1 == ']' && c2 != '[') {
				// a.append(c2);
				res.add(a.toString());
				a = new StringBuilder();
			} else {
				a.append(c1);
			}

		}
		if (a.toString().length() > 0)
			res.add(a.toString() + s.charAt(s.length() - 1));

		return res;
	}

	public static List<String> findListOfStrings2(String s) {

		List<String> res = new ArrayList<String>();
		if (s == null)
			return res;

		Stack<Character> st = new Stack<Character>();
		StringBuilder a = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			Character c1 = s.charAt(i);

			if (c1 == '(') {
				if (a.toString().length() > 0) {
					res.add(a.toString());
					a = new StringBuilder();
					st.push('(');

				} else {
					a.append('(');
				}
			} else if (c1 == ')') {
				if (st.peek() == '(') {
					st.pop();

					res.add(a.toString());
					a = new StringBuilder();
				} else {
					a.append(')');
				}
			} else if (c1 == '{') {
				if (a.toString().length() > 0) {
					res.add(a.toString());
					a = new StringBuilder();
					st.push('{');

				} else {
					a.append('{');
				}
			} else if (c1 == '}') {
				if (st.peek() == '}') {
					st.pop();

					res.add(a.toString());
					a = new StringBuilder();
				} else {
					a.append('}');
				}
			} else if (c1 == '[') {
				if (a.toString().length() > 0) {
					res.add(a.toString());
					a = new StringBuilder();
					st.push('[');

				} else {
					a.append('[');
				}
			} else if (c1 == ']') {
				if (st.peek() == ']') {
					st.pop();

					res.add(a.toString());
					a = new StringBuilder();
				} else {
					a.append(']');
				}
			}

			else {
				a.append(c1);
			}

		}
		if (a.toString().length() > 0)
			res.add(a.toString() + s.charAt(s.length() - 1));

		return res;
	}

	

}
