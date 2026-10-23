package sdm.cribbage;

public enum Suit {
    DIAMONDS('♦'),
    HEARTS('♥'),
    CLUBS('♣'),
    SPADES('♠');

    private final char symbol;

    Suit(char symbol) {
        this.symbol = symbol;
    }

    public static Suit of(char suitAsChar) {
        for (Suit suit : values()) {
            if (suit.symbol == suitAsChar)
                return suit;
        }
        throw new IllegalArgumentException("Unknown suit: " + suitAsChar);
    }
}
