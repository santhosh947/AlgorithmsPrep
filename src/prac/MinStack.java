package prac;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/min-stack/description/
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 * @author SC043656
 *
 */
class stackNode{
	int val;
	int minVal;
	stackNode next;
	public stackNode(int x)
	{
		val=x;
	}	
}

public class MinStack {
	stackNode st;

    /** initialize your data structure here. */
    public MinStack() {
         st=null;
    }
    
    public void push(int x) {
        if(st==null)
        {
        	st = new stackNode(x);
        	st.minVal=x;
        }else
        {
        	stackNode temp=new stackNode(x);
        	temp.next=st;
        	temp.minVal=Math.min(st.minVal, x);

        	st=temp;
        }
    }
    
    public void pop() {
        if(st==null)
        {
        	return;
        }else
        {
        	st=st.next;
        }
    }
    
    public int top() {
        if(st==null)
        {
        	return Integer.MIN_VALUE;
        }
        else
        {
        	return st.val;
        }
    }
    
    public int getMin() {
        if(st==null)
        {
        	return Integer.MIN_VALUE;
        }
        else
        {
        	return st.minVal;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
