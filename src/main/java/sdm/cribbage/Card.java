package sdm.cribbage;

public class Card {
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public static Card parse(String cardAsString) {
        char rankAsChar = cardAsString.charAt(0);
        char suitAsChar = cardAsString.charAt(1);
        return new Card(Rank.of(rankAsChar), Suit.of(suitAsChar));
    }

    public Suit suit() {
        return suit;
    }

    public Rank rank() {
        return rank;
    }

    public boolean hasSameRankAs(Card otherCard) {
        return this.rank == otherCard.rank;
    }

    public int value() {
        return rank.value();
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Card card)) return false;

        return rank == card.rank && suit == card.suit;
    }

    @Override
    public int hashCode() {
        int result = rank.hashCode();
        result = 31 * result + suit.hashCode();
        return result;
    }
}
