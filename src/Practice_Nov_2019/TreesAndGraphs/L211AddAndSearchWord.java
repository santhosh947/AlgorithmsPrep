package Practice_Nov_2019.TreesAndGraphs;

import java.util.*;

import prac.wordReverse;

class L211AddAndSearchWord {
    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();

        wd.addWord("bad");
        wd.addWord("dad");

        System.out.println(wd.search("."));
        System.out.println(wd.search("b.d"));
        System.out.println(wd.search(".dd"));

        // wd.addWord(word);
    }

    private static class Trie {
        HashMap<Character, Trie> child = new HashMap();
        char val;
        boolean isWord;

        Trie(HashMap<Character, Trie> ss, boolean flag, char v) {
            this.child = ss;
            this.isWord = flag;
            this.val = v;
        }
    }

    private static class WordDictionary {
        // HashMap<Character,Trie> hs;
        Trie root;
        Trie curr;
        Trie nav;

        /** Initialize your data structure here. */
        public WordDictionary() {
            // hs = new HashSet();
            // hs.add('0');
            root = new Trie(null, false, '0');
            curr = root;
            nav = root;
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            if (word != null) {
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    HashMap<Character, Trie> children = curr.child;
                    if (children == null) {
                        children = new HashMap();
                    }
                    Trie ch;

                    if (!children.containsKey(c)) {
                        boolean isend = false;
                        if (i == word.length() - 1) {
                            isend = true;
                        }
                        ch = new Trie(null, isend, c);
                        children.put(c, ch);
                        curr.child = children;
                    } else {
                        ch = children.get(c);
                    }
                    curr = ch;

                }
            }
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot
         * character '.' to represent any one letter.
         */
        public boolean search(String word) {
            if (word == null || word.length() == 0)
                return true;

            return search_rec(word, nav);

        }

        public boolean search_rec(String word, Trie nd) {
            if (word == null || word.length() == 0)
                return false;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                HashMap<Character, Trie> children = nd.child;
                if (children == null) {
                    return false;
                } else {
                    if (c != '.' && !children.containsKey(c)) {
                        return false;
                    } else if (c == '.') {
                        Iterator it = children.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry me = (Map.Entry) it.next();
                            Trie c_child = (Trie) me.getValue();
                            if (search_rec(word.substring(i+1, word.length()), c_child)) {
                                return true;
                            }

                        }
                    } else {
                        nd = children.get(c);
                    }
                }
            }
            return true;

        }
    }

}