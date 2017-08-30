package prac;

import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.Templates;

class TrieNode {
	Map<Character, TrieNode> child;
	boolean isAWord;

	TrieNode() {
		child = new HashMap<>();
		isAWord = false;
	}
}

public class trie {

	static TrieNode root;

	public static void main(String[] args) {
		root = new TrieNode();

		recersiveInsert("adc");
		recersiveInsert("ade");

		System.out.println("word ade exists: " + search("adc"));
		// System.out.println(recurrSear(root, "adeff", 0));
		System.out.println("word adef exists: " + search("ade"));

		System.out.println("Deleting word ade :" + delete("ade", root, 0));

		System.out.println("word ade exists: " + search("ade"));
		/*System.out.println("word adef exists: " + search("adef"));

		System.out.println("Deleting word adef :" + delete("adef",root, 0));

		System.out.println("word ade exists: " + search("ade"));
		System.out.println("word adef exists: " + search("adef"));
*/
	}
	/*if (node.isAWord) {
		if (node.child.isEmpty()) {
			System.out.println("is empty for word " + word);
		}
		node.isAWord = false;
	}
	return true;*/

	private static boolean delete(String word, TrieNode node, int i) {
		if (i == word.length()) {
			if(!node.isAWord)
				return false;
			node.isAWord=false;
			
			return node.child.size()==0;
		}

		char ch = word.charAt(i);
		TrieNode tempNode = node.child.get(ch);
		if (tempNode == null)
			return false;

		boolean deleteChild = delete(word, tempNode, i + 1);
		if(deleteChild)
		{
			node.child.remove(ch);
			return node.child.size()==0;
		}
		return false;
	}

	private static boolean recurrSear(TrieNode nod, String word, int i) {
		if (i == word.length()) {
			return nod.isAWord;
		}
		char ch = word.charAt(i);
		TrieNode tempNode = nod.child.get(ch);
		if (tempNode == null) {
			return false;
		}
		int tempCnt = i + 1;
		return recurrSear(tempNode, word, tempCnt);
	}

	private static void recersiveInsert(String word) {
		recurrInsert(root, word, 0);
	}

	private static void recurrInsert(TrieNode node, String word, int i) {
		try {

			if (i == word.length()) {
				node.isAWord = true;
				return;
			}

			char ch = word.charAt(i);
			TrieNode curr = node;
			TrieNode tmpNode = node.child.get(ch);
			if (tmpNode == null) {
				tmpNode = new TrieNode();
				curr.child.put(ch, tmpNode);
			}
			curr = tmpNode;
			int tmpCount = i + 1;
			recurrInsert(curr, word, tmpCount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static boolean search(String word) {
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = curr.child.get(ch);
			if (node == null) {
				return false;
			}
			curr = node;
		}
		return curr.isAWord;
	}

	public static void display() {
		TrieNode curr = root;
		while (curr != null) {
			System.out.println(curr.isAWord);
			for (int i = 0; i < curr.child.size(); i++) {
				System.out.println(curr.child.get(i));
			}
		}
	}

	public static void trieInsert(String word) {
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = curr.child.get(ch);
			if (node == null) {
				node = new TrieNode();
				curr.child.put(ch, node);
			}
			curr = node;
		}
		curr.isAWord = true;
	}

}
