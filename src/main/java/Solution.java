import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static class Trie {
        class Node {
            private HashMap<Character, Node> letters;
            private int count = 0;
            private boolean isWord = false;

            private Node() {
                letters = new HashMap<>();
            }
        }

        private Node root = new Node();

        public boolean addWord(String word) {
            if (!searchWord(word)) {
                Node current = root;
                for (char character : word.toCharArray()) {
                    current.count++;
                    if (current.letters.get(character) == null) {
                        current.letters.put(character, current = new Node());
                    } else {
                        current = current.letters.get(character);
                    }
                }
                current.isWord = true;
                current.count++;
                return true;
            } else return false;
        }

        public boolean searchWord(String word) {
            Node current = root;
            for (char character : word.toCharArray()) {
                if (current.letters.get(character) != null) current = current.letters.get(character);
                else return false;
            }
            return current.isWord;
        }

        public int howManyWords(String word) {
            Node current = root;
            for (char character : word.toCharArray()) {
                if (current.letters.get(character) != null) current = current.letters.get(character);
                else return 0;
            }
            return current.count;
        }

        public int calcContacts(String prefix) {
            Node current = root;
            for (char character : prefix.toCharArray()) {
                if (current.letters.get(character) != null) current = current.letters.get(character);
                else return 0;
            }
            int count = 0;
            return countContacts(current, count);
        }

        private int countContacts(Node node, int count) {
            if (node.isWord) count++;
            for (char letter : node.letters.keySet()) {
                count += countContacts(node.letters.get(letter), 0);
            }
            return count;
        }}

    public static void main(String[] args) {
        Trie myTrie = new Trie();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if (op.equalsIgnoreCase("add")) System.out.println("tu jestem");
            else if (op.equalsIgnoreCase("find")) System.out.println(myTrie.calcContacts(contact));
        }
    }
}
