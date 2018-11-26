package prac;
import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Chain {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String s;
    while ((s = in.readLine()) != null) {
        Map chain = new TreeMap();
        
        //Split the given string into elements using the seperator ';'
        String[] elements = s.split(";");
        boolean isABadChain=false;
        
        //Iterate through each element 
        for(String element : elements)
        {
            //Split the Key-Value pair from each element using the seperator '-'
            String[] keyValues = element.split("-");
            
            //check if the key is equal to value. If so it is a bad case, as it will end up in a loop.
            if(keyValues[0].equalsIgnoreCase(keyValues[1]))
            {
                isABadChain=true;
            }
            else
            {
                //Check if the chain already contains the Key, if doesn't exist insert a record
                // if the record already exists in the map then it is a bad chain.
                if(!chain.containsKey(keyValues[0]))
                {
                    chain.put(keyValues[0],keyValues[1]);
                }
                else
                {
                    isABadChain=true;
                    break;
                }
            }
        }
        
        
        int indexOfLinks = 1;
        int LengthOfChain = chain.size();
        
        String value = (String) chain.get("BEGIN");
        
        //Check if the chain has an element with BEGIN
        if(chain.get("BEGIN")==null)
        {
            isABadChain=true;
        }
        else
        {
            //Iterate through the chain.
            while(!value.equalsIgnoreCase("END") && indexOfLinks<LengthOfChain)
            {
                value=(String) chain.get(value);
                indexOfLinks++;
            }
        }
        
        //Validate if all the elements in the input are used in building a chain and also validate if there exists a "END" value
        if(!isABadChain && indexOfLinks==LengthOfChain && value.equalsIgnoreCase("END"))
        {
            System.out.println("GOOD");
        }
        else
        {
            System.out.println("BAD");
        }
    }
  }
}
