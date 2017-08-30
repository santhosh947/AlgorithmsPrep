package prac;

import java.util.HashMap;
import java.util.Map;

public class sortSequence {

	static nd Head;

	public static void main(String[] args) {
		String str = "ababcccdddddd";

		sortSeq(str);
	}

	private static void sortSeq(String str) {
		Map<Character, Integer> mp = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			if (mp.get(temp) != null) {
				int tmp_val = mp.get(temp);
				mp.put(temp, ++tmp_val);
			} else {
				mp.put(temp, 1);
			}
		}
		nd hd = BuildBST(mp);
		postOrder(hd);
	}

	private static void postOrder(nd hd) {
		if(hd==null)
		{
			return;
		}
		postOrder(hd.right);
		System.out.print(hd.ch); System.out.print(hd.val);
		postOrder(hd.left);
	}

	private static nd BuildBST(Map<Character, Integer> mp) {
		Head = null;
		for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
			nd newNd = new nd(entry.getKey(), entry.getValue());
			if (Head == null) {
				Head = newNd;
			} else {
				recurrsiveBST(Head, newNd);
			}
		}
		return Head;
	}

	private static void recurrsiveBST(nd hd, nd newNd) {
		if (hd == null) {
			hd=newNd;
			return;
		} else {
			nd tempNd;
			if (hd.val < newNd.val) {
				//tempNd=hd.right;
				recurrsiveBST(hd.right, newNd);
				hd.right = newNd;
				return;
			} else {
				if (hd.val == newNd.val && hd.ch < newNd.ch) {
					//tempNd=hd.left;
					recurrsiveBST(hd.left, newNd);
					hd.left = newNd;
					return;
				} else {
					//tempNd=hd.right;
					recurrsiveBST(hd.right, newNd);
					hd.right = newNd;
					return;
				}
			}
			/*recurrsiveBST(tempNd, newNd);
			tempNd=newNd;
			return;*/

		}

	}
}
