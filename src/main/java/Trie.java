import java.util.HashMap;

public class Trie {
    class Node {
        private HashMap<Character, Node> letters;
        private int count = 0;
        private boolean isWord = false;
    }

    private Node root;

    public void addWord(String word) {
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
    }
}
