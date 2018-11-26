package Amz_Nov_2018;

import java.util.ArrayList;
import java.util.List;

public class Q2 {

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(8);
		
		List<Integer> l2 = new ArrayList<>();
		l2.add(2);
		l2.add(15);
		
		List<Integer> l3 = new ArrayList<>();
		l3.add(3);
		l3.add(9);
		
		List<Integer> l4 = new ArrayList<>();
		l4.add(1);
		l4.add(8);
		
		List<Integer> l5 = new ArrayList<>();
		l5.add(2);
		l5.add(11);
		
		List<Integer> l6 = new ArrayList<>();
		l6.add(3);
		l6.add(12);
		
		List<List<Integer>> forwardRouteList = new ArrayList<List<Integer>>();
		
		forwardRouteList.add(l1);
		forwardRouteList.add(l2);
		forwardRouteList.add(l3);
		
		List<List<Integer>> returnRouteList = new ArrayList<List<Integer>>();

		returnRouteList.add(l4);
		returnRouteList.add(l5);
		returnRouteList.add(l6);

		
		List<List<Integer>> nearBy = optimalUtilization(20, forwardRouteList, returnRouteList);
		for(List<Integer> loc :nearBy)
		{
			System.out.print(loc.get(0)+","+loc.get(1));
			System.out.println();
		}
		
	}
	
	/**
	 * We are iterating for returnRouteList for every route within the forwardRouteList and calculating the distance of between the two 
	 * routes and comparing it against the maxDist so far if the new distance is less than the maxTravelDist and greater than the in memory
	 * maxDist we are overriding the maxDist also the List with the new routes.
	 * 
	 * If the newly calculated Distance is equal to the in memory maxDist we are adding the routes to the resultset.
	 * 
	 * If the newly calculated Distance is less than the in memory maxDist we are ignoring the routes.
	 * 
	 * if we have n number of forwardRouteList and m number of returnRouteList the time complexity of the code is O(n*m) as we are 
	 * iterating for every combination.
	 */
	
    public static List<List<Integer>> optimalUtilization(int maxTravelDist, 
                                    List<List<Integer>> forwardRouteList,
                                    List<List<Integer>> returnRouteList)
	{
    	int fwdCt = forwardRouteList.size();
    	int retCt = returnRouteList.size();
    	
    	int maxDist = 0;
    	
    	List<List<Integer>> result = new ArrayList<List<Integer>>();

    	
    	
    	for (int i = 0; i < fwdCt; i++) {
			for (int j = 0; j < retCt; j++) {
				int dis = forwardRouteList.get(i).get(1) + returnRouteList.get(j).get(1);
				if(dis == maxDist)
				{
					maxDist = forwardRouteList.get(i).get(1) + returnRouteList.get(j).get(1);
					List<Integer> l4 = new ArrayList<>();
					l4.add(forwardRouteList.get(i).get(0));
					l4.add(returnRouteList.get(j).get(0));
					result.add(l4);
				}	
				if(dis > maxDist && dis <= maxTravelDist)
				{
					result = new ArrayList<List<Integer>>(); 
					maxDist = forwardRouteList.get(i).get(1) + returnRouteList.get(j).get(1);
					List<Integer> l4 = new ArrayList<>();
					l4.add(forwardRouteList.get(i).get(0));
					l4.add(returnRouteList.get(j).get(0));
					result.add(l4);
				}
				
			}
		}
    	return result;
    }
    
    
}

