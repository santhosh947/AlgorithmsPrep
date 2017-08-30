package prac;

public class Solution
{ 
	public static void main(String[] args) {
		int[] arr = {5,3,6,1,4,2};
		System.out.println(bstDistance(arr, 6,2, 4));
		System.out.println(findLCA(root, 2, 4).data);

	}
   static class Node{
    int data;
    Node left;
    Node right;
    public Node(int data)
    {
        this.data=data;
        this.left=null;
        this.right=null;
    }
    }
    private static Node root = null;
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static int bstDistance(int[] values, int n, int node1, int node2)
	{
	    //first step is to build a  BST
	    for(int i=0;i<values.length;i++)
	    {
	        Node nd = new Node(values[i]);
	        if(root==null)
	        {
	            root=nd;
	        }
	        else if(!insert(nd,root))
	        {
	            return -1;
	        }
	    }
	    
	    //After building the BST 
	    //Find the distance between two given nodes 
	    
	   return findDistance(node1,node2, n);
	}
	
    public static int findDistance(int node1,int node2,int length)
	{
	    int a = findPathLength(root,node1) - 1;
	    int b = findPathLength(root,node2) - 1;
	    
	    int lca1 = findLCA(root,node1,node2).data;
	    int lcaDist = findPathLength(root,lca1) -1;
	    
	    return (a+b)-2 * lcaDist;
	}
	
	public static int findPathLength(Node root1,int node1)
	{
	    if(root1!=null)
	    {
	        int x=0;
	        if((root1.data==node1) || (x=findPathLength(root1.left,node1))>0 || (x=findPathLength(root1.right,node1))>0)
	        {
	            return x+1;
	        }
	        return 0;
	    }
	    return 0;
	}
	
	public static Node findLCA(Node root1,int node1,int node2)
	{
	    if(root1!=null)
	    {
	        if(root1.data==node1 || root1.data==node2)
	        {
	            return root1;
	        }
	        Node left = findLCA(root1.left,node1,node2);
	        Node right  = findLCA(root1.right,node1,node2);
	        if(left !=null && right!=null)
	        {
	            return root1;
	        }
	        if(left!=null)
	        {
	            return left;
	        }
	        if(right!=null)     
	        {
	            return right;
	        }
	    }
	        return null;
	    }
	    
	
	
	public static boolean insert(Node nd,Node root1)
	{
	    if(nd.data==root1.data)
	    {
	        return false;
	    }
	    else if (nd.data<root1.data)
	    {
	        if(root1.left==null)
	        {
	            root1.left=nd;
	        }
	        else
	        {
	            return insert(nd,root1.left);
	        }
	    }
	    else if(nd.data>root1.data)
	    {
	        if(root1.right==null)
	       {
	           root1.right=nd;
	       }
	       else
	       {
	           return insert(nd,root1.right);
	       }
	    }
	    return true;
	}
	// METHOD SIGNATURE ENDS
}