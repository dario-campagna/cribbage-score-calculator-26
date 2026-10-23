package sdm.cribbage;

import java.util.Map;

public enum Suit {
    DIAMONDS, HEARTS, CLUBS, SPADES;

    private static final Map<Character, Suit> suitByChar = Map.of(
            '♦', Suit.DIAMONDS,
            '♥', Suit.HEARTS,
            '♣', Suit.CLUBS,
            '♠', Suit.SPADES
    );

    public static Suit of(char suitAsChar) {
        return suitByChar.get(suitAsChar);
    }
}
