package Practice_Nov_2019.TreesAndGraphs;

import java.util.*;

class ToplogicalSort {
    public static void main(String[] args) {
        ArrayList<String> l = new ArrayList();
        l.add("sa");
        l.add("bc");
        l.add("ga");

        ArrayList<String> l2 = new ArrayList();
        l2.add("fa");
        l2.add("mbc");
        l2.add("xa");

        ArrayList<String> l3 = new ArrayList();
        l3.add("ring");
        l3.add("not");
        l3.add("kim");

        ArrayList<ArrayList<String>> ll = new ArrayList();
        ll.add(l);
        ll.add(l2);
        ll.add(l3);


        ArrayList<String> wds = new ArrayList<>();
        wds.add("aca");
        wds.add("fmx");
        wds.add("fbx");

        System.out.println(isValidList(ll, wds));

     //   System.out.println(isValid(l,"sif"));
      //  System.out.println(isValid(l,"six"));

    }

    public static boolean isValid(List<String> l, String wd) {
        for (int i = 0; i < wd.length(); i++) {
            char c = wd.charAt(i);
            String l_wd = l.get(i);
            if (l_wd.indexOf(c) == -1)
                return false;
        }
        return true;
    }

    public static boolean isValidList(ArrayList<ArrayList<String>> ll, ArrayList<String> wds) {
        HashMap<ArrayList<String>, HashSet<String>> adj = new HashMap<ArrayList<String>, HashSet<String>>();
        HashMap<String, HashSet<ArrayList<String>>> lookup = new HashMap<>();

        for (int i = 0; i < ll.size(); i++) {
            for (int j = 0; j < wds.size(); j++) {
                if (isValid(ll.get(i), wds.get(j))) {
                    HashSet<String> hs = new HashSet<String>();
                    hs = adj.getOrDefault(ll.get(i), new HashSet<String>());
                    hs.add(wds.get(j));
                    adj.put(ll.get(i), hs);

                    HashSet<ArrayList<String>> cache = lookup.getOrDefault(wds.get(j), new HashSet());
                    cache.add(ll.get(i));
                    lookup.put(wds.get(j), cache);

                }
            }
        }

        Queue<ArrayList<String>> qu = new LinkedList();
       // for (int i = 0; i < adj.size(); i++) {
            Set entrySet = adj.entrySet();
            Iterator it = entrySet.iterator();
            while (it.hasNext()) {
                Map.Entry me = (Map.Entry) it.next();

                if (adj.get(me.getKey()).size() == 1) {
                    qu.add((ArrayList<String>)me.getKey());
                }
            }
      //  }
        int count=0;

        while(!qu.isEmpty())
        {
            ArrayList<String> pp = qu.remove();
            count++;
            it = adj.get(pp).iterator();
            String wd="";
            while(it.hasNext())
            {
                wd= (String)it.next();
            }
            HashSet<ArrayList<String>> hs = lookup.get(wd);
            Iterator it2 = hs.iterator();

            while(it2.hasNext())
            {
                ArrayList<String> w = (ArrayList<String>)it2.next();
                if(w!=pp)
                {
                    HashSet<String> wdsHs = adj.get(w);
                    wdsHs.remove(wd);
                    adj.put(w,wdsHs);
                    if(wdsHs.size()==1)
                    {
                        qu.add(w);
                    }
                }

            }

        }


        return wds.size()==count;
    }

}