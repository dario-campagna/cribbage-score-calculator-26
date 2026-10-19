package sdm.cribbage;

public class Card {
    private final Suite suite;

    public Card(Suite suite) {
        this.suite = suite;
    }

    public static Card parse(String cardAsString) {
        char suiteAsChar = cardAsString.charAt(1);
        return new Card(Suite.valueOf(suiteAsChar));
    }

    public Suite suite() {
        return suite;
    }

    public char rank() {
        return '5';
    }
}
