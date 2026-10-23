package sdm.cribbage;

public enum Rank {
    ACE('A', 1),
    TWO('2', 2),
    THREE('3', 3),
    FOUR('4', 4),
    FIVE('5', 5),
    SIX('6', 6),
    SEVEN('7', 7),
    EIGHT('8', 8),
    NINE('9', 9),
    TEN('0', 10),
    JACK('J', 10),
    QUEEN('Q', 10),
    KING('K', 10);

    private final char symbol;
    private final int value;

    Rank(char symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    public static Rank of(char rankAsChar) {
        for (Rank rank : values()) {
            if (rank.symbol == rankAsChar)
                return rank;
        }
        throw new IllegalArgumentException("Unknown rank: " + rankAsChar);
    }

    public int value() {
        return value;
    }
}
