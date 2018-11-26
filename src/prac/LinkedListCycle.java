package prac;

import java.util.HashSet;
import java.util.Iterator;

import javax.print.attribute.standard.Finishings;

public class LinkedListCycle {
	public static void main(String[] args) {
		linkedList11 head1= new linkedList11(10);
		linkedList11 nd2=new linkedList11(20);
		linkedList11 nd3=new linkedList11(30);
		linkedList11 nd4=new linkedList11(40);
		linkedList11 nd5=new linkedList11(50);
		linkedList11 nd6=new linkedList11(60);
		linkedList11 nd7=new linkedList11(30);



		head1.next=nd2;
		nd2.next=nd3;
		nd3.next=nd4;
		nd4.next=nd5;
		nd5.next=nd6;
		nd6.next=nd7;
		
		
		linkedList11 head2= new linkedList11(100);
		head2.next=nd4;

		
		HashSet<linkedList11> test = new HashSet<>();
		test.add(head2);
		
		Iterator<linkedList11> it = test.iterator();
		while(it.hasNext())
		{
			System.out.println("TEST ");
			linkedList11 temp = it.next();
			if(test.contains(head2))
				System.out.println("True");
			else
				System.out.println("false");
			//SSystem.out.println(it.ne	xt().data);
			System.out.println("TEST ");

		}
		System.out.println(hasCycle2(head1));
		System.out.println(FindMergeNode(head1,head2));
	}
	
	
	static int FindMergeNode(linkedList11 headA, linkedList11 headB) {
	    // Complete this function
	    // Do not write the main method.
		
		
	    
		return 0;

	}

	
	static boolean hasCycle(linkedList11 head) {
	    if(head==null)
	        return true;
	    linkedList11 slow=head;
	    linkedList11 fast=(head.next == null) ? null : head.next;
	    if(fast==null)
	        return true;
	    while(slow!=null && fast!=null)
	          {
	              if(slow==fast)
	                  return true;
	              slow=slow.next;
	              if(fast.next!=null)
	            	  fast=fast.next.next;
	              else
	            	  fast=null;
	          }
	     return false;

	}
	
	static boolean hasCycle2(linkedList11 head) {
	    if(head==null || head.next==null)
	        return true;
	    linkedList11 slow=head;
	    linkedList11 fast=head.next;
	    while(slow!=null && fast!=null)
	          {
	              if(slow==fast)
	                  return true;
	              slow=slow.next;
	              if(fast.next!=null)
		            fast=fast.next.next;
		          else
		            fast=null;
	          }
	     return false;

	}

}
