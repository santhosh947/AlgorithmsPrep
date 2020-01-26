package Practice_Nov_2019;

class L825FriendsOfAppropriateAges {
    public static void main(String[] args) {
        int[] ages1={16,16};
        int[] ages2= {16,17,18};
        int[] ages3={20,30,100,110,120};
        System.out.println(numFriendRequests(ages1));        
        System.out.println(numFriendRequests(ages2));
        System.out.println(numFriendRequests(ages3));
    }


    public static int numFriendRequests(int[] ages) {
        int res =0;
        int[] num_ages = new int[121];
        int[] sum_ages = new int[121];
        for(int t: ages)
            num_ages[t]++;
        
        for(int i=1;i<121;i++)
        {
            sum_ages[i]=num_ages[i]+sum_ages[i-1];
        }
        
        for(int i=15;i<121;i++)
        {
            if(num_ages[i]>0)
            {
                int count= sum_ages[i]-sum_ages[(i/2+7)];
                res+= count*num_ages[i]-num_ages[i];
            }
        }
            
        return res;
    }























    public static int numFriendRequests3(int[] ages) {
        int res = 0;
        int[] numInAge = new int[121], sumInAge = new int[121];
        
        for(int i : ages) 
            numInAge[i] ++;
        
        for(int i = 1; i <= 120; ++i) 
            sumInAge[i] = numInAge[i] + sumInAge[i - 1];
        
        for(int i = 15; i <= 120; ++i) {
            if(numInAge[i] == 0) 
                continue;
            int count = sumInAge[i] - sumInAge[i / 2 + 7];
            res += count * numInAge[i] - numInAge[i]; //people will not friend request themselves, so  - numInAge[i]
        }
        return res;
    }

    public static int numFriendRequests2(int[] ages) {
        int[] count = new int[121];
        for (int age: ages) 
            count[age]++;

        int ans = 0;
        for (int ageA = 0; ageA <= 120; ageA++) {
            int countA = count[ageA];
            for (int ageB = 0; ageB <= 120; ageB++) {
                int countB = count[ageB];
                if (ageA * 0.5 + 7 >= ageB) 
                    continue;
                if (ageA < ageB)
                    continue;
                if (ageA < 100 && 100 < ageB)
                    continue;
                ans += countA * countB;
                if (ageA == ageB) 
                    ans -= countA;
            }
        }

        return ans;
    }
}