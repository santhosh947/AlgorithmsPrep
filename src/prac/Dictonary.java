package prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class TrieNode1 {
	Map<Character, TrieNode1> child;
	boolean isAWord;

	TrieNode1() {
		child = new HashMap<>();
		isAWord = false;
	}
}

public class Dictonary {
	static TrieNode1 root = null;
	static int wordCnt = 0;

	public static void main(String[] args) {
		root = new TrieNode1();

		Scanner in = new Scanner(System.in);
		ArrayList<String> operation = new ArrayList<>();
		ArrayList<String> words = new ArrayList<>();
		
		operation.add("add");
		operation.add("add");
		operation.add("find");
		operation.add("find");
		words.add("hack");
		words.add("hackerrank");
		words.add("hac");
		words.add("hak");
		int n = 4;
		for (int i = 0; i < n; i++) {
			if (operation.get(i).equals("add")) {
				TrieAddOperation(words.get(i));
			} else if (operation.get(i).equals("find")) {
				wordCnt=0;
				System.out.println(recurreseiveSearch(words.get(i), 0, root));

				// System.out.println(TrieFindOperation(words.get(i)));
			}
		}
	}

	private static int recurreseiveSearch(String word, int i, TrieNode1 node) {
		if (i == word.length()) {

			findNumberOfPaths(node);
			return wordCnt;
		}
		// TrieNode1 curr = root;
		char ch = word.charAt(i);
		TrieNode1 nd = node.child.get(ch);
		if (nd == null) {
			return 0;
		}
		return recurreseiveSearch(word, i + 1, nd);

	}

	private static void findNumberOfPaths(TrieNode1 node) {
		int cnt = 0;
		if (node != null) {
			Set set = node.child.entrySet();
			Iterator it = set.iterator();

			while (it.hasNext()) {
				Map.Entry me = (Map.Entry) it.next();

				//System.out.println("Processing Char " + me.getKey());
				//System.out.println("Processing Node " + me.getValue());
				findNumberOfPaths(node.child.get(me.getKey()));

			}
			if (node.isAWord) {
				wordCnt += 1;
			}
		}
	}

	private static int TrieFindOperation(String word) {

		TrieNode1 curr = root;
		int charCnt = 0;
		int i = 0;
		while (curr.child.get(word.charAt(i)) != null) {
			char ch = word.charAt(i);
			TrieNode1 nd = curr.child.get(ch);
			if (nd == null && charCnt <= word.length()) {
				return 0;
			} else {
				charCnt++;
			}
			curr = nd;
			i++;
		}

		return charCnt;
	}

	/*
	 * private static int TrieFindOperation(String word) {
	 * 
	 * TrieNode1 curr = root; int charCnt = 0; for (int i = 0; i <
	 * word.length(); i++) { char ch = word.charAt(i); TrieNode1 nd =
	 * curr.child.get(ch); if (nd == null && charCnt <= word.length()) { return
	 * 0; } else { charCnt++; } curr = nd; } return charCnt; }
	 */

	public static void TrieAddOperation(String word) {
		TrieNode1 curr = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode1 node = curr.child.get(ch);
			if (node == null) {
				node = new TrieNode1();
				curr.child.put(ch, node);
			}
			curr = node;
		}
		curr.isAWord = true;
	}
}