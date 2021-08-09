package Prc_2020_Q4;

import java.util.*;
    class Node{
        int v;
       // int min;
        Node next;
        
        Node(int v,Node next){
            this.v = v;
            this.next=next;
        }
        
        /**Node(int v,int min,Node next){
            this.v = v;
            this.min = min;
            this.next=next;
        }**/
    }
    
    class MinStack {
        public static void main(String[] args) {
            MinStack obj = new MinStack();
            obj.push(-2);
            obj.push(0);
            obj.push(-3);

            System.out.println(obj.getMin());
            obj.pop();
            System.out.println(obj.getMin());
            obj.pop();
            System.out.println(obj.getMin());
        }
        Node head;
        Stack<Integer> prevMin;
        Map<Integer, Integer> lookup;
        /** initialize your data structure here. */
        public MinStack() {
            prevMin = new Stack<>();
            lookup = new HashMap<>();
        }
        
        public void push(int val) {
            if(head == null){
                //head = new Node(val, val, null);
                head = new Node(val, null);
                prevMin.add(val);
                lookup.put(val,1);
            }else{
              //  head = new Node(val, Math.min(val, head.min), head);
                head = new Node(val, head);
    
                if(prevMin.peek()>val){
                    prevMin.add(val);
                    lookup.put(val, 1);
                }
                else if(prevMin.peek()==val){
                    lookup.put(prevMin.peek(), lookup.get(prevMin.peek())+1);
                }else{
                }
            }        
        }
        
        public void pop() {
            if(!prevMin.isEmpty() && head.v == prevMin.peek()){
                if(lookup.get(prevMin.peek()) == 1){
                    lookup.remove(prevMin.peek());
                    prevMin.pop();
                }else{
                    lookup.put(prevMin.peek(), lookup.get(prevMin.peek())-1);
                }
            }
            head = head.next;
        }
        
        public int top() {
            return head.v;
        }
        
        public int getMin() {
            /**if(head!=null)
                return head.min;
            else
                return -1;**/
            
            if(!prevMin.isEmpty())
                return prevMin.peek();   
            else
                return -1;
                
        }
    }
    
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
