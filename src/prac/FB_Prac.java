package prac;

public class FB_Prac {
public static void main(String[] args) {
	System.out.println(numSetBits(00000000000000000000000000001011L));
}
public static int numSetBits(long a) {
    String st = String.valueOf(a);
    int len=0;
    for(int i=0;i<st.length();i++)
    {
        if(st.charAt(i)=='1')
        {
            len++;
        }
    }
    return len;
}

}
