package Practice_Nov_2019.TreesAndGraphs;

import java.util.*;

class L994RottingOranges {
    public static void main(String[] args) {
        int[][] g = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };

       // System.out.println(orangesRotting(g));

       String para = "Bob hit a ball, the hit BALL flew far after it was hit.";

       String[] ba = {"hit"};

       String p2 = "Bob. hIt, baLl";
       String[] b2 = {"bob", "hit"};
       System.out.println(mostCommonWord(para,ba));
    }

    private static class point {
        int i;
        int j;

        point(int a, int b) {
            i = a;
            j = b;
        }
    }

    public static int orangesRotting(int[][] grid) {
        Queue<point> qu = new LinkedList();

        int[][] visited = new int[grid.length][grid[0].length];

        int res=-1;
        int curr_ct=0;
        int prev_ct=0;
        int num_1 = 0;
        for(int k=0;k<grid.length;k++)
        {
            for(int l=0;l<grid[0].length;l++)
            {
                if(grid[k][l]==2)
                {
                    qu.add(new point(k,l));
                    curr_ct++;

                }
                if(grid[k][l]==1)
                {
                    num_1++;
                }
                
            }
        }

        while(!qu.isEmpty())
        {
            point p = qu.poll();
            int a = p.i;
            int b = p.j;
            //check top
            if(a>0 && grid[a-1][b]==1)
            {
                qu.add(new point(a-1,b));
                grid[a-1][b]=0;
                num_1--;
                prev_ct++;
            }

            //left
            if(b>0 && grid[a][b-1]==1)
            {
                qu.add(new point(a,b-1));
                grid[a][b-1]=0;
                num_1--;

                prev_ct++;

            }

             //right
             if(b<grid[0].length-1 && grid[a][b+1]==1)
             {
                 qu.add(new point(a,b+1));
                 grid[a][b+1]=0;
                 num_1--;

                 prev_ct++;

             }

              //below
              if(a<grid.length-1 && grid[a+1][b]==1)
              {
                  qu.add(new point(a+1,b));
                  grid[a+1][b]=0;
                  num_1--;

                  prev_ct++;

              }
              curr_ct--;
              if(curr_ct==0)
              {
                  res++;
                  curr_ct=prev_ct;
                  prev_ct=0;
              }
        }   
        
        if(num_1>0)
            return -1;
        return res==-1?0:res;  
    }


    public static String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> wordCount = new HashMap();
        StringBuilder sb = new StringBuilder();
        paragraph = paragraph.toLowerCase();
        Set<String> ban = new HashSet();
        int res = 0;
        String common_word = null;
        for(int i=0;i<banned.length;i++)
        {
            ban.add(banned[i].toLowerCase());
        }
        for(int i=0;i<paragraph.length();i++)
        {
            char c = paragraph.charAt(i);
            if(c>='a' && c<='z')
            {
                sb.append(c);
            }
            else {
                String s = sb.toString();
                if(!ban.contains(s)){
                    int local_count=-1;
                    if(wordCount.containsKey(s))
                    {
                        local_count=wordCount.get(s)+1;
                        if(res<local_count)
                        {
                            common_word = s;
                            res=local_count;
                        }
                    }
                    else{
                        local_count=1;
                    }
                    
                    if(res<local_count)
                        {
                            common_word = s;
                            res=local_count;
                        }
                    wordCount.put(s, wordCount.getOrDefault(s,0)+1);
                }
                sb=new StringBuilder();
               // i++;
                while(i<paragraph.length() && !(paragraph.charAt(i)>='a' && paragraph.charAt(i)<='z'))
                {
                    i++;
                }
                i--;
            }
        }
        
        if(sb.toString().length()>0)
        {
                            String s = sb.toString();

            if(!ban.contains(s)){
                    int local_count=-1;
                    if(wordCount.containsKey(s))
                    {
                        local_count=wordCount.get(s)+1;
                        if(res<local_count)
                        {
                            common_word = s;
                            res=local_count;
                        }
                    }
                    else{
                        local_count=1;
                    }
                    
                    if(res<local_count)
                        {
                            common_word = s;
                            res=local_count;
                        }
                    wordCount.put(s, wordCount.getOrDefault(s,0)+1);
                }
        }
        
        return common_word;
    }
}