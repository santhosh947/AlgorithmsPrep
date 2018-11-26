package prac;

import java.util.HashSet;
import java.util.Set;

public class WordLadder {
	public static void main(String[] args) {
		Set<String> s=new HashSet<String>();
		s.add("hot");
		s.add("dot");
		s.add("dog");
		s.add("lot");
		s.add("log");
		s.add("cog");
		String beginWord = "hit", endWord = "cog";
		
/*		long startTime = System.nanoTime();

		System.out.println(ladderLength2(beginWord, endWord, s));
		
		long endTime = System.nanoTime();
		
		long duration1 = (endTime - startTime);
*/
		long startTime2 = System.nanoTime();

		System.out.println(ladderLength(beginWord, endWord, s));
		
		long endTime2 = System.nanoTime();
		
		long duration2 = (endTime2 - startTime2);
		
		//System.out.println(endTime);
		System.out.println(endTime2);

		
	}
	public static int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Set<String> reached = new HashSet<String>();
        reached.add(beginWord);
        wordDict.add(endWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<String>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordDict.contains(word)) {
                            toAdd.add(word);
                            wordDict.remove(word);
                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0) return 0;
            reached = toAdd;
        }
        return distance;
    }
	
	
	public static int ladderLength2(String beginWord, String endWord, Set<String> wordList) {
		Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

		int len = 1;
		int strLen = beginWord.length();
		HashSet<String> visited = new HashSet<String>();
		
		beginSet.add(beginWord);
		endSet.add(endWord);
		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
			if (beginSet.size() > endSet.size()) {
				Set<String> set = beginSet;
				beginSet = endSet;
				endSet = set;
			}

			Set<String> temp = new HashSet<String>();
			for (String word : beginSet) {
				char[] chs = word.toCharArray();

				for (int i = 0; i < chs.length; i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						char old = chs[i];
						chs[i] = c;
						String target = String.valueOf(chs);

						if (endSet.contains(target)) {
							return len + 1;
						}

						if (!visited.contains(target) && wordList.contains(target)) {
							temp.add(target);
							visited.add(target);
						}
						chs[i] = old;
					}
				}
			}

			beginSet = temp;
			len++;
		}
		
		return 0;
	}
}
