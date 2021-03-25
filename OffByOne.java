public class OffByOne implements CharacterComparator {

    /** Returns whether the difference between characters is 1. */
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 1;
    }
}
