package Prc_2020_Q4;

public class L418SentenceScreenFitting {
    public static void main(String[] args) {
        // String[] sen = { "f", "p", "a" };
        // System.out.println(wordsTyping_optimal(sen, 8, 7));

        // String[] sen2 = { "a", "bcd", "e" };
        // System.out.println(wordsTyping_optimal(sen2, 3, 6));

        // String[] sen3 = { "I", "had", "apple", "pie" };
        // System.out.println(wordsTyping(sen3, 4, 5));

        String[] sen2 = { "abc", "de", "f" };
        System.out.println(wordsTyping_optimal(sen2, 4, 6));
    }

    public static int wordsTyping(String[] sentence, int rows, int cols) {
        int res = 0;
        if (rows <= 0 || cols <= 0 || sentence == null || sentence.length <= 0)
            return res;
        String wd = sentence[0];
        int wd_indx = 0;
        int col_index = 0;
        int row_holder = rows;
        boolean just_found = false;

        while (rows > 0) {
            int wd_len = wd.length();
            if (wd_len > cols) {
                return 0;
            }

            if (wd_len > cols - col_index) {
                rows--;
                col_index = 0;
                if (res > 0 && just_found) {
                    int rows_occupied = row_holder - rows;
                    res += res * (rows % rows_occupied);
                    rows = rows / rows_occupied;
                    break;
                }
            } else {
                just_found = false;
                col_index += wd_len + 1;
                wd_indx++;
                wd_indx = wd_indx >= sentence.length ? 0 : wd_indx;
                if (wd_indx == 0) {
                    res++;
                    just_found = true;
                }
                wd = sentence[wd_indx];
            }

        }
        return res;
    }

    public static int wordsTyping_optimal(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, l = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % l) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start - 1) % l) != ' ') {
                    start--;
                }
            }
        }

        return start / s.length();
    }
}
