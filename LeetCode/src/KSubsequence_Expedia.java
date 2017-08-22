import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.careercup.com/question?id=5205996814204928
 * @author santh
 *
 */
public class KSubsequence_Expedia {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,1};
		//findSequenceDivisibleBy(arr, 3);
		//function(arr, 3);
	}
	private static void findSequenceDivisibleBy(int[] arr, int num) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            int sum = 0;

            for (int j = 0; j < arr.length - i; j++) {
               sum += arr[i + j];
                temp.add(arr[i + j]);

                if (sum % num == 0) {
                    count++;
                    System.out.println(temp);
                }
            }
        }

        System.out.println("Count " + count);
    }
	
	public static void function(int[] arr, int k) {

        int size = arr.length;
        // list is used to print the pairs
        Map<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();
        
        int currentSum = 0;
        for (int index = 0; index < size; index++) {
                currentSum += arr[index];
                List<Integer> list = hashMap.get(currentSum % k);
                if (null != list) {
                        list.add(index);

                } else {
                        list = new ArrayList<Integer>();
                        list.add(index);
                }
                hashMap.put(currentSum % k, list);
        }
        
        int noOfSubArray = 0;
        for(Map.Entry<Integer, List<Integer>> entry : hashMap.entrySet()) {
                Integer key = entry.getKey();
                Integer listSize = entry.getValue().size();
                if(key == 0) {
                        noOfSubArray += (listSize*(listSize+1))/2;
                } else {
                        noOfSubArray += (listSize*(listSize-1))/2;
                }
        }
        
        System.out.println("No of subArray in O(k+n) time complexity "+noOfSubArray);
        
}
	
	
	public List<Integer> topKFrequent(int[] nums, int k) {

		List<Integer>[] bucket = new List[nums.length + 1];
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

		for (int n : nums) {
			frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
		}

		for (int key : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}

		List<Integer> res = new ArrayList<>();

		for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
			if (bucket[pos] != null) {
				res.addAll(bucket[pos]);
			}
		}
		return res;
	}
}
