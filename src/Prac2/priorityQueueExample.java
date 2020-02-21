package Prac2;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.*;

public class priorityQueueExample {
	public static void main(String args[]) 
    { 
        // Creating empty priority queue 
        // PriorityQueue<String> pQueue = 
        //                   new PriorityQueue<String>(); 
  
        // pQueue.add("shopnow"); 
        // pQueue.add("nowshop"); 
        // pQueue.add("mymarket");
  
        // Iterator itr = pQueue.iterator(); 
        // while (itr.hasNext()) 
        //     System.out.println(itr.next()); 

    
  
        // // Removing the top priority element (or head) and 
        // // printing the modified pQueue using poll() 
        // pQueue.poll(); 
        // System.out.println("After removing an element" + 
        //                    "with poll function:"); 
        // Iterator<String> itr2 = pQueue.iterator(); 
        // while (itr2.hasNext()) 
        //     System.out.println(itr2.next()); 
  
        // // Removing Java using remove() 
        // pQueue.remove("Java"); 
        // System.out.println("after removing Java with" + 
        //                    " remove function:"); 
        // Iterator<String> itr3 = pQueue.iterator(); 
        // while (itr3.hasNext()) 
        //     System.out.println(itr3.next()); 
  
        // // Check if an element is present using contains() 
        // boolean b = pQueue.contains("C"); 
        // System.out.println ( "Priority queue contains C " + 
        //                      "or not?: " + b); 
  
        // // Getting objects from the queue using toArray() 
        // // in an array and print the array  
        // Object[] arr = pQueue.toArray(); 
        // System.out.println ( "Value in array: "); 
        // for (int i = 0; i<arr.length; i++) 
        //   System.out.println ( "Value: " + arr[i].toString()) ; 



        PriorityQueue<Integer> pq= new PriorityQueue<Integer>();
        pq.add(10);

        pq.add(20);
        pq.add(5);
        Iterator it = pq.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }

        System.out.println("MAX HEAP");
        PriorityQueue<Integer> pq2= new PriorityQueue<Integer>(Collections.reverseOrder());
        pq2.add(10);

        pq2.add(20);
        pq2.add(5);
        Iterator it2 = pq2.iterator();
        while(it2.hasNext())
        {
            System.out.println(it2.next());
        }
    } 
}
