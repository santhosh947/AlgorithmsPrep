package Prc_2020_Q4.DropBox;
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
       String[][] in = {{"0","APPEND","Hey "}, {"1","APPEND","there"}, {"2","APPEND"," you"}};

       System.out.println(textEditor(in));
    }




/**class Node {
    String op;
    String wd;
    String st_idx;
    String end_idx;
    
    
    
}**/


/**class Node {
    String op;
    String wd;
    String st_idx;
    String end_idx;
    
    
    
}**/
//Append, hey, "", 0
public static String textEditor(String[][] input) {
    Stack<String> history = new Stack<>();
    Stack<String> redoHistory = new Stack<>();
    
    Stack<String> previousCmds = new Stack<>();
    Stack<String> redoCmds = new Stack<>();
    int rows = input.length;
    long[] timeStamp = new long[rows];
    String[] ops = new String[rows];
    String[] words = new String[rows];
    
    
    Map<Long, List<String>> mapping = new HashMap<>();
    for(int i=0;i<input.length;i++){
        timeStamp[i] = Long.valueOf(input[i][0]);
        ops[i] = input[i][1];
        words[i] = input[i].length == 3 ? input[i][2] : "";
        
        List<String> value = new ArrayList<>();
        value.add(ops[i]);
        value.add(words[i]);
        
        if(input[i].length > 3){
            value.add(input[i][3]);
        }
        
        mapping.put(timeStamp[i], value);        
    }
    
    Arrays.sort(timeStamp);
    
   // StringBuilder res1 = new StringBuilder();
    String alteredWord = "";
    history.add("");
    for(int i=0;i<timeStamp.length;i++){
        List<String> values = mapping.get(timeStamp[i]);
        
       // String operation = values.get(0);
        //String word = values.get(1);
        
         alteredWord = alterWord(timeStamp[i],values, previousCmds, redoCmds, history, redoHistory);
    }
    
    return alteredWord;
   // return res1.toString();

}

public static String alterWord(Long timeStamp,List<String> values, Stack<String> prevCmds, Stack<String> redoCmds, Stack<String> history, Stack<String> redoHistory){
    String op = values.get(0);
    String wordSoFar = history.peek();
    //String word = values.get(1);
    
    StringBuilder res = new StringBuilder(history.peek());
    
    if(op.equals("APPEND")){
        res.append(values.get(1));
        
    } else if(op == "BACKSPACE") {
        if(res.toString().length()>0){
        res = new StringBuilder(wordSoFar.substring(0, wordSoFar.length()-1));     
        }   
    } else if(op == "UNDO"){
        if(!history.isEmpty()) {
            String temp = history.pop();
            redoHistory.add(temp);
                     //""
            temp = history.isEmpty() ? "" : history.peek();
         res = new StringBuilder(temp);
            
        }
        
    } else if(op == "REDO"){
        
    } else if(op == "SELECT"){
        
    } else {
        
    }
    //Hey
    //"","HEY"
    //""
    history.add(res.toString());
   // prevCmds.add(values.get(0));    
    return res.toString();
}

}

