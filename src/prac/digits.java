package prac;

public class digits {
	public static void main(String[] args) {
		System.out.println(onceInATram(431929));
		/*int i=987;
		
		System.out.println(i/100);
		i=i%100;
		System.out.println(i/10);
		i=i%10;
		System.out.println(i);*/
	}
	
	private static String onceInATram(int i) {
		if(!(i>=100000 && i<=1000000-2))
		{
			return "";
		}
		String res=String.valueOf(i);
		for(int a=i+1;a<1000000-2;a++)
		{
			String temp=String.valueOf(a);
			int s1=findSumOfDigits(temp.substring(0, 3));
			int s2=findSumOfDigits(temp.substring(3,6));
			if(s1==s2)
				return String.valueOf(a);
		}
		return res;
	}

	private static int findSumOfDigits(String str) {
		int i=Integer.valueOf(str);
		int s = 0;
        s+=(i/100);
        i=i%100;
        s+=i/10;
        i=i%10;
        s+=i;
		return s;
	}

	static String onceInATram1(int x) {
        String res=String.valueOf(x);
        String temp=String.valueOf(x);
        int sum1 = Integer.parseInt(temp.substring(0,1)) + Integer.parseInt(temp.substring(1,2))+Integer.parseInt(temp.substring(2,3));
        int sum2 = Integer.parseInt(temp.substring(3,4)) + Integer.parseInt(temp.substring(4,5)) + Integer.parseInt(temp.substring(5,6));
        
        int diff = Integer.valueOf(temp.substring(3))+1;
        for(int num=diff;num<999;num++)
        {
        	int i=num;
            int s = 0;
            s+=(i/100);
            i=i%100;
            s+=i/10;
            i=i%10;
            s+=i;
            if(s==sum1)
            {
            	String rr = String.valueOf(num);
            	if(rr.length()==1)
            	{
            		rr="00"+rr;
            	}
            	if(rr.length()==2)
            		rr="0"+rr;
            	String str= temp.substring(0,3)+rr;
            	return str;
            }
        }
        return res;
    }
}
