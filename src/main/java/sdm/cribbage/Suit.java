package sdm.cribbage;

import java.util.HashMap;
import java.util.Map;

public enum Suit {
    DIAMONDS, HEARTS, CLUBS, SPADES;
    
    private static Map<Character, Suit> suitsByChar = new HashMap<>(){{
        put('♦', Suit.DIAMONDS);
        put('♥', Suit.HEARTS);
        put('♣', Suit.CLUBS);
        put('♠', Suit.SPADES);
    }};

    public static Suit valueOf(char suitAsChar) {
        return suitsByChar.get(suitAsChar);
    }
}
