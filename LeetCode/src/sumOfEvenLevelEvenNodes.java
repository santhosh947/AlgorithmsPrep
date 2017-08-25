import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 
SQL :
 
 1. Customer table 
 customer_id: A key used to uniquely identify each customer in the table.

# store_id: A foreign key identifying the customer's “home store.” Customers are not limited to renting only from this store, but this is the store they generally shop at.

# first_name: The customer's first name.

# last_name: The customer's last name.

# email: The customer's email address.

# address : string the customer's address

# active: Indicates whether the customer is an active customer. Setting this to FALSE serves as an alternative to deleting a customer outright. Most queries should have a WHERE active = TRUE clause.

# create_date: The date the customer was added to the system. This date is automatically set using a trigger during an INSERT.

# last_update: The time that the row was created or most recently updated.

# 2. Transaction Table
# transaction_id:  unique id
# customer_id: A key used to uniquely identify each customer in the table.REFERENCE TO customer table's customer_id
# Amount : integer the dollar amount the cumstomer spend for this transaction 
# datetime : UTC date time of the transaction 
 
 # Task :  

# Write Query to get Min-amount,Max-amount,Avg-amount, Precrentage of customers that spend more than 300 $ for 2016 :  from 01/01/2016- 12/31/2016
 
 Query :
 
 Select MIN(Amount) as Min-amount, MAX(Amount) as Max-amount, AVG(Amount), (count(distnict customer_id)/(Select count(*) from Customer)) * 100 from Customer c Transaction t where c.customer_id=t.customer_id and t.amount > 300 and datetime >='01-01-2016' and datetime <='12-31-2016';
 
 1.
 2.
 3.
 4.
 
 select (count(distnict customer_id)/(Select count(*) from Customer))*100 from Customer c Transaction t where c.customer_id=t.customer_id and t.amount>300;
 
 sum all even nodes in even levels in given binary tree
# input :
#            1               -1
#        3        4             -2
#      5   6   9    4-  2^2
#   1    2             -2^3
# 9   6
#
0-
1  - 
      2*0
      2*1
      2*2
      i
      2*i+1
      0,1,3,4,5,6,
      
      if(level==even && 2^0 ==1)
         1+
      i==i+2^level+1;
      
      2i+1
      2i+2
      0,1,2,3,4,5,6,7,8,9,10
res= {1,3,4,5,6,9,4,1,2,null,null,9,6}

levelcount=5;

int result;
level=0
2^0=1
index=0;
elemCunt
while loop check if the level is even && 2^level>elemcount
      result+=res[index];
      elemCunt++;
  

index+=2^(level);
index=2


# output :
#    1 + 5 + 9 + 9 = 24
 
 */

class Node{
	int val;
	Node left;
	Node right;
	Node(int val)
	{
		this.val=val;
	}
}

class sumOfEvenLevelEvenNodes {
  public static void main(String[] args) {
    
    Node root=new Node(1);
    Node l1=new Node(3);
    Node r1=new Node(4);
    root.left=l1;
    root.right=r1;
    
    Node ll1=new Node(5);
    Node lr1=new Node(6);
    
     Node rl1=new Node(9);
    Node rr1=new Node(4);
    
    l1.left=ll1;
    l1.right=lr1;
    r1.left=rl1;
    r1.right=rr1;
    
     Node lev3_l1=new Node(1);
    Node lev3_r1=new Node(2);
    
    ll1.left=lev3_l1;
    ll1.right=lev3_r1;
    
    
    System.out.println(sumOfEvenLevelEvenNodes(root));
    
   
    
  }
  
  public static int sumOfEvenLevelEvenNodes(Node root)
  {
    int result=0;
    if(root==null)
      return result;
    
    Queue<Node> queue = new LinkedList<Node>();
    //1
    queue.offer(root);
    
    while(!queue.isEmpty())
    {
      int numOfElements=queue.size();
      int level=(int) (Math.log(numOfElements) /Math.log(2));
      //System.out.println("level " + level);
      for(int i=0;i<numOfElements;i++)
      {
        if(queue.peek()==null)
          queue.poll();
        else
        {
        if(level%2==0 && i%2==0 && queue.peek()!=null)
        {
          result+=queue.peek().val;
        }
        if(queue.peek().left!=null)
        {
          queue.offer(queue.peek().left);
        }
        else
        {
          queue.offer(null);
        }
        
        if(queue.peek().right!=null)
        {
          queue.offer(queue.peek().right);
        }
        else
        {
          queue.offer(null);
        }
        queue.poll();
        }
        
      }
    }
    return result;
  }
}
