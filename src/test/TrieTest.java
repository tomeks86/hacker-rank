import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class TrieTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Trie testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new Trie();
    }

    @Test
    public void shouldBeEmptyRoot() {
        testObject.addWord("c");
        assertNull(testObject);
    }

}