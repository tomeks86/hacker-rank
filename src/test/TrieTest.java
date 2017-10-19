import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.*;

public class TrieTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Trie testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new Trie();
    }

    @Test
    public void shouldAddWord() {
        testObject.addWord("ab");
        assertTrue(testObject.addWord("aa"));
    }

    @Test
    public void shouldFindAddedWord() {
        testObject.addWord("abc");
        assertTrue(testObject.searchWord("abc"));
    }

    @Test
    public void shouldNotFindAddedWord() {
        testObject.addWord("abc");
        assertFalse(testObject.searchWord("aaa"));
    }

    @Test
    public void shouldFindTwoWords() {
        testObject.addWord("abc");
        testObject.addWord("abcd");
        assertEquals(testObject.howManyWords("ab"), 2);
    }

    @Test
    public void shouldFindZeroWords() {
        testObject.addWord("abc");
        testObject.addWord("abcd");
        assertEquals(testObject.howManyWords("b"), 0);
    }

    @Test
    public void shouldFindThreeWords() {
        testObject.addWord("abcd");
        testObject.addWord("ab");
        testObject.addWord("abcc");
        assertEquals(testObject.howManyWords("ab"), 3);
    }

}