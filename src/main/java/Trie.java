import java.util.HashMap;

public class Trie {
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
}
