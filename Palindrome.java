public class Palindrome {

    /** Given parameter word, a string.
     * Return a Deque where the characters appear in the same order as in the String.
     */
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> wordDeque = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    /* Should return true if the given word is a palindrome, and false otherwise. */
    public boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }
        Deque<Character> wordDeque = wordToDeque(word);
        return helperIsPalindrome(wordDeque);
    }

    /** Helper function for isPalindrome */
    private boolean helperIsPalindrome(Deque<Character> wordDeque) {
        if (wordDeque.size() == 0 || wordDeque.size() == 1) {
            return true;
        }
        char first = wordDeque.removeFirst();
        char last = wordDeque.removeLast();
        if (first == last) {
            return helperIsPalindrome(wordDeque);
        }
        return false;
    }

    /** Return true if the word is a palindrome according to the character comparison test.
     * Character comparison test passed in as argument cc as a CharacterComparator object.
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null) {
            return false;
        } else if (cc == null) {
            return isPalindrome(word);
        } else {
            Deque<Character> wordDeque = wordToDeque(word);
            return helperIsPalindrome(wordDeque, cc);
        }
    }

    /** Helper function for isPalindrome for offByOne palindromes*/
    private boolean helperIsPalindrome(Deque<Character> wordDeque, CharacterComparator cc) {
        if (wordDeque.size() == 0 || wordDeque.size() == 1) {
            return true;
        }
        char first = wordDeque.removeFirst();
        char last = wordDeque.removeLast();
        if (cc.equalChars(first, last)) {
            return helperIsPalindrome(wordDeque, cc);
        }
        return false;
    }
}
