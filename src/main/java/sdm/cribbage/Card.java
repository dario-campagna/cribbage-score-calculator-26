package sdm.cribbage;

public class Card {
    private final char rank;
    private final Suite suite;

    public Card(char rankAsChar, Suite suite) {
        this.rank = rankAsChar;
        this.suite = suite;
    }

    public static Card parse(String cardAsString) {
        char rankAsChar = cardAsString.charAt(0);
        char suiteAsChar = cardAsString.charAt(1);
        return new Card(rankAsChar, Suite.valueOf(suiteAsChar));
    }

    public Suite suite() {
        return suite;
    }

    public char rank() {
        return rank;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Card card)) return false;

        return rank == card.rank && suite == card.suite;
    }

    @Override
    public int hashCode() {
        int result = rank;
        result = 31 * result + suite.hashCode();
        return result;
    }
}
