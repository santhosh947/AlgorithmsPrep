package Prac2;

public class SentenceScreenFitting {
	public static void main(String[] args) {

		String[] sen1 = { "hello", "world" };
		String[] sen2 = { "a", "bcd", "e" };
		String[] sen3 = { "I", "had", "apple", "pie" };

		//System.out.println(numOfLines(2, 8, sen1));
		//System.out.println(numOfLines(3, 6, sen2));
	//	System.out.println(numOfLines(4, 5, sen3));
		System.out.println(wordsTyping(sen2, 3,6));
	}

	public static int numOfLines(int r, int c, String[] sen) {
		int num = 0;
		if (r < 1 || c > 20000 || sen.length > 100)
			return num;

		int rIte = 0;
		int cIte = 0;
		boolean endOfSentence = false;
		while (rIte < r) {
			endOfSentence = false;
			for (int i = 0; i < sen.length && rIte < r; i++) {
				int wordLen = sen[i].length();
				if (wordLen > c) {
					rIte = r;
					endOfSentence = false;
					num = 0;
					break;
				}
				if (wordLen + cIte <= c) {
					cIte += wordLen;
					cIte++;
					if (i == sen.length - 1)
						endOfSentence = true;
				} else {
					rIte++;
					cIte = 0;
					i--;
				}
			}
			if (endOfSentence)
				num++;
		}

		return num;
	}
	
	public static int wordsTyping(String[] sentence, int rows, int cols) {
        StringBuilder str = new StringBuilder();
        for (String s : sentence) {
            s = s + " ";
            str.append(s);
        }
        
        int start = 0;
        for (int i = 0; i < rows; i++) {
            start = start + cols;
            if (str.charAt(start % str.length()) == ' ') {
                start++;
            } else {
                while (start > 0 && str.charAt((start-1) % str.length())  != ' ') {
                    start--;
                }
            }
        }
        return start / str.length();
    }
}
