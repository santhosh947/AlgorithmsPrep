package Practice_Nov_2019;

import java.util.*;
import java.util.Map.Entry;

class emp {
    int id;
    String name;

    emp(int v, String n) {
        id = v;
        name = n;
    }
}

class empComp implements Comparator<emp> {
    public int compare(emp e1, emp e2) {
        if (e2.id > e1.id)
            return 1;
        else if (e1.id > e2.id)
            return -1;
        else
            return 0;
    }
}

class DataStructuresSampleCode {
    public static void main(String[] args) {
        Map<Integer, Integer> hm = new HashMap();

        hm.put(1, 1);
        hm.put(2, 2);

        System.out.println(hm.getOrDefault(1, 100));

        Iterator it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry em = (Entry) it.next();
            System.out.println(em.getKey() + "->" + em.getValue());
        }

        System.out.println("******************** STACK ***********************");
        Stack<Integer> st = new Stack();
        st.push(100);
        st.push(200);

        if (st.contains(100)) {
            System.out.println("Contains 100");
        }

        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }

        System.out.println("******************** Queue ***********************");
        Queue<Integer> qu = new LinkedList();
        qu.add(1000);
        qu.add(2000);

        if (qu.contains(1000)) {
            System.out.println("Contains 10000");
        }
        while (!qu.isEmpty()) {
            System.out.println(qu.poll());
        }

        System.out.println("******************** Priority Queue default behaviour ***********************");
        // By default it stores in the ascending order
        PriorityQueue<Integer> pqe = new PriorityQueue<>();
        pqe.add(10000);
        pqe.add(2000);

        if (pqe.contains(1000)) {
            System.out.println("Contains 10000");
        }
        while (!pqe.isEmpty()) {
            System.out.println(pqe.poll());
        }

        System.out.println("******************** Priority Queue store in reverse order ***********************");
        PriorityQueue<Integer> pqe_rev = new PriorityQueue<>(Collections.reverseOrder());
        pqe_rev.add(10000);
        pqe_rev.add(2000);

        if (pqe_rev.contains(1000)) {
            System.out.println("Contains 10000");
        }
        while (!pqe_rev.isEmpty()) {
            System.out.println(pqe_rev.poll());
        }

        System.out.println("******************** Priority Queue with object emp ***********************");
        PriorityQueue<emp> pqe_obj = new PriorityQueue<>(new empComp());

        emp e1 = new emp(1, "sam");
        emp e2 = new emp(2, "dad");
        pqe_obj.add(e1);
        pqe_obj.add(e2);

        if (pqe_obj.contains(e1)) {
            System.out.println(e1.id + " " + e1.name);
        }
        while (!pqe_obj.isEmpty()) {
            emp e = pqe_obj.poll();
            System.out.println(e.id + "" + e.name);
        }

    }

    // public class empComp implements Comparator<emp>{
    // public int compare(emp e1, emp e2){
    // if(e2.id > e1.id)
    // return 1;
    // else if(e1.id>e2.id)
    // return -1;
    // else
    // return 0;
    // }
    // }

    // private static class emp {
    // int id;
    // String name;
    // emp(int v, String n)
    // {
    // id = v;
    // name = n;
    // }
    // }
}