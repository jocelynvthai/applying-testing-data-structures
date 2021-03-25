import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator offByN0 = new OffByN(0);
    static CharacterComparator offByN1 = new OffByN(1);
    static CharacterComparator offByN25 = new OffByN(25);

    @Test
    public void testEqualChars() {
        assertTrue(offByN0.equalChars('a', 'a'));
        assertTrue(offByN1.equalChars('a', 'b'));
        assertTrue(offByN1.equalChars('b', 'a'));
        assertTrue(offByN1.equalChars('y', 'z'));
        assertTrue(offByN25.equalChars('a', 'z'));

        assertFalse(offByN1.equalChars('a', 'a'));
        assertFalse(offByN1.equalChars('a', 'z'));
        assertFalse(offByN1.equalChars('y', 'a'));

        assertTrue(offByN1.equalChars('%', '&'));
        assertTrue(offByN1.equalChars('&', '%'));
    }
}
