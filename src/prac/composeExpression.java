package prac;

public class composeExpression {

	public static void main(String[] args) {
		 
		long startTime = System.nanoTime();
		
		System.out.println(reverseString("Hi how are you"));
		long endTime = System.nanoTime();

		long duration = (endTime - startTime); 
		System.out.println("SB " + duration);

		long startTime2 = System.nanoTime();
		
		System.out.println(reversePlus("Hi how are you"));
		long endTime2 = System.nanoTime();

		long duration1 = (endTime2 - startTime2); 
		System.out.println("Plus " + duration1);

	}

	public static String reverseString(String s) {
        StringBuilder op = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--)
        {
            op=op.append(s.charAt(i));
        }
        return op.toString();
    }
	
	 public static String reversePlus(String s) {
	        
	        String op="";
	        for(int i=s.length()-1;i>=0;i--)
	        {
	            op+=s.charAt(i);
	        }
	        return op;
	    }
}
