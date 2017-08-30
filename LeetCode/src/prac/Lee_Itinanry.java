package prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

//https://leetcode.com/problems/reconstruct-itinerary/#/description

public class Lee_Itinanry {
	public static void main(String[] args) {
		Map<String, ArrayList<String>> hm = new HashMap<>();
		List<ArrayList<String>> ll = new ArrayList<ArrayList<String>>();
		//System.out.println(findLowerString("", "ATL"));
		
		String[][] tickets = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
		 List<String> op = findItinerary3(tickets);
		 for(String s:op)
		 {
			 System.out.println(s);
		 }
	}

	public static String findLowerString(String s, String t) {
		if (s.length() == 0)
			return "";
		if (s.charAt(0) > t.charAt(0))
			return t;
		else if (t.charAt(0) > s.charAt(0))
			return s;
		else
			return findLowerString(s.substring(1, s.length()),
					t.substring(1, t.length()));
	}

	class Node {
		String s;
		List<Node> childs;

		public Node(String s, List<Node> ch) {
			this.s = s;
			this.childs = ch;
		}
	}
	
	static Map<String, PriorityQueue<String>> flights;
    static LinkedList<String> path;

    public static List<String> findItinerary3(String[][] tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        for (String[] ticket : tickets) {
        	if(!flights.containsKey(ticket[0]))
        	{
        		flights.put(ticket[0], new PriorityQueue<String>());
        	}            
            flights.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK");
        return path;
    }

    public static void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll());
        path.addFirst(departure);
    }
	
	public static List<String> findItinerary(String[][] tickets) {
        List<String> ans = new ArrayList<String>();
        if(tickets == null || tickets.length == 0) return ans;
        Map<String, PriorityQueue<String>> ticketsMap = new HashMap<>();
        for(int i = 0; i < tickets.length; i++) {
            if(!ticketsMap.containsKey(tickets[i][0])) ticketsMap.put(tickets[i][0], new PriorityQueue<String>());
            ticketsMap.get(tickets[i][0]).add(tickets[i][1]);
        }

        String curr = "JFK";
        Stack<String> drawBack = new Stack<String>();
        for(int i = 0; i < tickets.length; i++) {
            while(!ticketsMap.containsKey(curr) || ticketsMap.get(curr).isEmpty()) {
                drawBack.push(curr);
                curr = ans.remove(ans.size()-1);
            }
            ans.add(curr);
            curr = ticketsMap.get(curr).poll();
        }
        ans.add(curr);
        while(!drawBack.isEmpty()) ans.add(drawBack.pop());
        return ans;
    }

	public List<String> findItinerary2(String[][] tickets) {
		Map<String, ArrayList<String>> hm = new HashMap<>();
		for (int i = 0; i < tickets.length; i++) {
			if (hm.get(tickets[i][0]) != null) {
				ArrayList<String> l = hm.get(tickets[i][0]);
				l.add(tickets[i][1]);
				hm.put(tickets[i][0], l);
			} else {
				ArrayList<String> l = new ArrayList<String>();
				l.add(tickets[i][1]);
				hm.put(tickets[i][0], l);
			}
		}

		String head = "";
		Stack<String> st = new Stack<String>();
		// st.push(head);
		st.push("JFK");
		List<String> res = new ArrayList<String>();
		res.add("JFK");
		while (!st.isEmpty()) {
			head = st.pop();
			List<String> temp = hm.get(head);
			String nextStop = "";
			for (int i = 0; i < temp.size(); i++) {
				if (i == 0)
					nextStop = temp.get(i);
				else
					nextStop = findLowerString(nextStop, temp.get(i));
			}
			res.add(nextStop);
			st.push(nextStop);
		}
		return res;

	}
}
