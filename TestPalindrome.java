import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertFalse(palindrome.isPalindrome(null));

        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("flake"));

        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("dad"));
    }

    @Test
    public void testIsPalindromeTwo() {
        assertFalse(palindrome.isPalindrome(null, offByOne));

        assertFalse(palindrome.isPalindrome("cat", offByOne));
        assertFalse(palindrome.isPalindrome("racecar", offByOne));

        assertTrue(palindrome.isPalindrome("", offByOne));
        assertTrue(palindrome.isPalindrome("a", offByOne));
        assertTrue(palindrome.isPalindrome("flake", offByOne));

        // no CharacterComparator is provided should still run
        assertTrue(palindrome.isPalindrome("", null));
        assertTrue(palindrome.isPalindrome("a", null));
        assertTrue(palindrome.isPalindrome("racecar", null));

        assertFalse(palindrome.isPalindrome("cat", null));
        assertFalse(palindrome.isPalindrome(null, null));
        assertFalse(palindrome.isPalindrome("flake", null));

    }
}
