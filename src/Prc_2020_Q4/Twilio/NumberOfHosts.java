package Prc_2020_Q4.Twilio;

import java.io.*;

import java.util.*;
import java.util.Map.Entry;

public class NumberOfHosts {
    public static void main(String[] args) {
        BufferedReader reader;

        try {

            // File file = new File(".");
            // for (String fileNames : file.list()) {
            // System.out.println(fileNames);
            // }
            reader = new BufferedReader(new FileReader("file1.txt"));

            Map<String, Integer> count = new HashMap<>();

            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);

                String[] str = line.split(" ");

                count.put(str[0], count.getOrDefault(str[0], 0) + 1);

                line = reader.readLine();
            }

            File fout = new File("file1.txt");
            FileOutputStream fos = new FileOutputStream(fout);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

           
            Iterator it = count.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry em = (Entry) it.next();
                System.out.println(em.getKey() + "->" + em.getValue());
                bw.write((em.getKey() + "->" + em.getValue()));
                bw.newLine();
            }
            bw.close();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
