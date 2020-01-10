package Practice_Nov_2019.MockInterviews_LeetCode;

import java.util.*;

import Prac2.ArrayListEx;

class Exam6 {
    public static void main(String[] args) {

        List<Integer> r = partitionLabels("ababcbacadefegdehijhklij");

        for(int t : r)
        {
            System.out.print(t+",");
        }



        // System.out.println();
        // int[] r1= {7,8,13,15};
        // int[] r2 = {10,8,12,20};

        // System.out.println(isRectangleOverlap(r1,r2));

        // int[] rr1= {0,0,1,1};
        // int[] rr2 = {1,0,2,1};

        // System.out.println(isRectangleOverlap(rr1,rr2));
    }

    public static List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;
        
        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }

    public static List<Integer> partitionLabels2(String S) {
        List<Integer> res = new ArrayList<>();
        List<String> store = new ArrayList();

        Set<Character> st = new HashSet();
        Set<Character> old_st = new HashSet();

        StringBuilder prev = new StringBuilder("");
        StringBuilder old_prev = new StringBuilder("");

        StringBuilder curr = new StringBuilder();

        for(int i=0;i<S.length();i++)
        {
            char c= S.charAt(i);
            if(st.contains(c) || old_st.contains(c))
            {
               // if(prev.length() == 0)
               if(prev.toString().indexOf(c)>-1 && store.size()>0)
               {
                  prev=old_prev;
                   store.remove(store.get(store.size()-1));
               }
                prev.append(curr);
                prev.append(c);
            }
            else
            {
                if(prev.length()==0)
                {
                    curr.append(c);
                }
                else{
                    old_prev= prev;

                    store.add(prev.toString());
                    prev = new StringBuilder();
                    curr=new StringBuilder();
                    old_st = st;
                    st = new HashSet();
                    curr.append(c);
                }
                st.add(c);
            }
        }

        for(int j=0;j<store.size();j++)
        {
            res.add(store.get(j).length());
        }

        return res;
    }

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        return rec1[0] < rec2[2] && rec2[0] < rec1[2] && rec1[1] < rec2[3] && rec2[1] < rec1[3];

       // return helper(r1,r2) || helper(r1,r2);
        
    }

    private static boolean helper(int[] r1, int[] r2) {
        int x0=r1[0];
        int y0=r1[1];

        int x2=r1[2];
        int y2=r1[3];      


        int ax0=r2[0];
        int ay0=r2[1];       

        if((Math.abs(ax0-x0)< Math.abs(x2-x0)) && (Math.abs(ax0-x2)<Math.abs(x2-x0)) && 
        (Math.abs(ay0-y0)< Math.abs(y2-y0)) && (Math.abs(ay0-y2)<Math.abs(y2-y0)))  
            return true;

        return false;
    }
}