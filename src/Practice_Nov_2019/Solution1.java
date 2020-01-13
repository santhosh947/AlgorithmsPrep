package Practice_Nov_2019;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.*;
import java.util.Queue;
// CLASS BEGINS, THIS CLASS IS REQUIRED

        
public class Solution1
{        
    private static final int updated = 1;
    private final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    
    public int minimumDays(int rows, int columns, List<List<Integer>> grid)
    {
        int res=-1;
        int outOfDate=0;

        Queue<Point> updatedServers = new ArrayDeque<>();
        for (int r = 0; r < grid.size(); r++) {
            for (int c = 0; c < grid.get(0).size(); c++) {
                if (grid.get(r).get(c) == updated) {
                    updatedServers.add(new Point(r, c));
                } else {
                    outOfDate++;
                }
            }
        }

        if(outOfDate==0)
            return -1;

        for (int days = 1; !updatedServers.isEmpty(); days++) {
            for (int sz = updatedServers.size(); sz > 0; sz--) {
                    Point pt = updatedServers.poll();
                    for (int[] dir : DIRS) {
                        int r = pt.r + dir[0];
                        int c = pt.c + dir[1];
                        if (isValidPosition(grid, r, c)) {
                            outOfDate--;
                            if (outOfDate == 0) 
                                return days;
                            grid.get(r).set(c, updated);
                            updatedServers.add(new Point(r, c));
                        }
                    }
                }
            }       

        return res;       
    }

    private boolean isValidPosition(List<List<Integer>> grid, int r, int c) {
        return r >= 0 && r < grid.size() &&c >= 0 && c < grid.get(0).size() && grid.get(r).get(c) != updated;
    }
    private static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    
}


public ArrayList<String> popularNFeatures(int numFeatures,int topFeatures,List<String> possibleFeatures,	int numFeatureRequests, List<String> featureRequests)
{
    ArrayList<String> res = new ArrayList();
    Map<String, Integer> counter = new HashMap();         

    for(int i=0;i<numFeatureRequests;i++)
    {
        String req = featureRequests.get(i);
        for(int j=0;j<possibleFeatures.size();j++)
        {
            String feature = possibleFeatures.get(j);
            if(req.indexOf(feature)>-1)
            {
                counter.put(feature, counter.getOrDefault(feature, 0)+1);
                //qu.add()
            }
        }
    }  

    /**
     * Traversed through the featureReq and identfied number of times the possible feature has been requested. 
     * After this step I have the indivdual feature and number of times its been requestd. 
     * O(featureRequests*numFeatures)
     * 
     * I used an hashmap to store the number of times a feature is requested to the associated features with the same number of requests and used a PriorityQueue to 
     * store them in a sorted order based on the feature.
     * O(numFeatures*(nlogn)) n is the number of associated features
     * 
     * 
     * At the end, I going over the hashmap based on the counter which points to the top feature till we find the 
     * requested top features. 
     * 
    */
    Map<Integer, PriorityQueue<String>> st = new HashMap();
    int top=0;

    Iterator it3 = counter.entrySet().iterator();
    while (it3.hasNext()) {
        Map.Entry pair2 = (Map.Entry)it3.next();
        String k =(String) pair2.getKey();
        int vv = (int)pair2.getValue();
        top = Math.max(top, vv);

        PriorityQueue<String> pqq = new PriorityQueue<>();

        
        if(st.containsKey(vv))
        {
            pqq = st.get(vv);
        }
        pqq.add(k);
        st.put(vv, pqq);            
    }

    int tt= topFeatures;

    for(int i=top;i>0 && tt>0;i--)
    {
        if(st.containsKey(i))
        {
            PriorityQueue<String> vv = st.get(i);
            
                Iterator it6 = vv.iterator();
                while(it6.hasNext() && tt>0)
                {
                    res.add((String)it6.next());
                    tt--;
                }             

        }
    }

    return res;
}
}