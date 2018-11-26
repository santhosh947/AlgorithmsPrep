import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
public class LevelOrderZIGZAG {

	public static void main(String[] args) {

		Node root = new Node(1);
		Node l1 = new Node(3);
		Node r1 = new Node(4);
		root.left = l1;
		root.right = r1;

		Node ll1 = new Node(5);
		Node lr1 = new Node(6);

		Node rl1 = new Node(9);
		Node rr1 = new Node(4);

		l1.left = ll1;
		l1.right = lr1;
		r1.left = rl1;
		r1.right = rr1;

		Node lev3_l1 = new Node(1);
		Node lev3_r1 = new Node(2);

		ll1.left = lev3_l1;
		ll1.right = lev3_r1;

		List<Integer> res=zigzag(root);
		
		for(int i:res)
		{
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		List<List<Integer>> res1=zigzagLevelOrder(root);
		for(List<Integer> i: res1)
		{
			System.out.println(i.toString());
		}

	}

	public static List<Integer> zigzag(Node root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;

		Queue<Node> queue = new LinkedList<Node>();
		// 1
		queue.offer(root);

		boolean flag=true;
		while (!queue.isEmpty()) {
			int numOfElements = queue.size();
		    if(flag)
		    	flag=false;
		    else
		    	flag=true;

			// int level=(int) (Math.log(numOfElements) /Math.log(2));
			// System.out.println("level " + level);
			for (int i = 0; i < numOfElements; i++) {
				if (queue.peek() == null)
					queue.poll();
				else {
					res.add(queue.peek().val);
					if (flag) {
						if (queue.peek().left != null) {
							queue.offer(queue.peek().left);
						}

						if (queue.peek().right != null) {
							queue.offer(queue.peek().right);
						}
					}
					else
					{		

						if (queue.peek().right != null) {
							queue.offer(queue.peek().right);
						}
						if (queue.peek().left != null) {
							queue.offer(queue.peek().left);
						}

					}
					queue.poll();
				}

			}
		}
		return res;
	}
	
	
	 public static List<List<Integer>> zigzagLevelOrder(Node root) 
	    {
	        List<List<Integer>> sol = new ArrayList<>();
	        travel(root, sol, 0);
	        return sol;
	    }
	    
	    private static void travel(Node curr, List<List<Integer>> sol, int level)
	    {
	        if(curr == null) return;
	        
	        if(sol.size() <= level)
	        {
	            List<Integer> newLevel = new LinkedList<>();
	            sol.add(newLevel);
	        }
	        
	        List<Integer> collection  = sol.get(level);
	        if(level % 2 == 0) collection.add(curr.val);
	        else collection.add(0, curr.val);
	        
	        travel(curr.left, sol, level + 1);
	        travel(curr.right, sol, level + 1);
	    }
}
