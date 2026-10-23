package sdm.cribbage;

public class Card {
    private final char rank;
    private final Suit suit;

    public Card(char rankAsChar, Suit suit) {
        this.rank = rankAsChar;
        this.suit = suit;
    }

    public static Card parse(String cardAsString) {
        char rankAsChar = cardAsString.charAt(0);
        char suitAsChar = cardAsString.charAt(1);
        return new Card(rankAsChar, Suit.valueOf(suitAsChar));
    }

    public Suit suit() {
        return suit;
    }

    public char rank() {
        return rank;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Card card)) return false;

        return rank == card.rank && suit == card.suit;
    }

    @Override
    public int hashCode() {
        int result = rank;
        result = 31 * result + suit.hashCode();
        return result;
    }

    public boolean hasSameRankAs(Card otherCard) {
        return this.rank == otherCard.rank();
    }
}
