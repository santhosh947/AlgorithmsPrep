package Old_files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @see https://www.careercup.com/question?id=5636146378833920
 * @author santh
 *
 */
public class SortArrayBasedOnElementFrequency {
	public static void main(String[] args) {
		System.out.println(frequencySort("ddabbac"));
	}
	
	public static String frequencySort(String s) {
	    if (s == null) {
	        return null;
	    }
	    Map<Character, Integer> map = new HashMap();
	    char[] charArray = s.toCharArray();
	    int max = 0;
	    for (Character c : charArray) {
	        if (!map.containsKey(c)) {
	            map.put(c, 0);
	        }
	        map.put(c, map.get(c) + 1);
	        max = Math.max(max, map.get(c));
	    }

	    List<Character>[] array = buildArray(map, max);

	    return buildString(array);
	}

	private static List<Character>[] buildArray(Map<Character, Integer> map, int maxCount) {
	    List<Character>[] array = new List[maxCount + 1];
	    for (Character c : map.keySet()) {
	        int count = map.get(c);
	        if (array[count] == null) {
	            array[count] = new ArrayList();
	        }
	        array[count].add(c);
	    }
	    return array;
	}

	private static List<Character>[] buildArray2(Map<Character, Integer> map, int maxCount) {
	    List<Character>[] array = new List[maxCount + 1];
	    for (Character c : map.keySet()) {
	        int count = map.get(c);
	        if (array[count] == null) {
	            array[count] = new ArrayList();
	        }
	        array[count].add(c);
	    }
	    return array;
	}

	
	private static String buildString(List<Character>[] array) {
	    StringBuilder sb = new StringBuilder();
	    for (int i = array.length - 1; i > 0; i--) {
	        List<Character> list = array[i];
	        if (list != null) {
	            for (Character c : list) {
	                for (int j = 0; j < i; j++) {
	                    sb.append(c);
	                }
	            }
	        }
	    }
	    return sb.toString();
	}
}
