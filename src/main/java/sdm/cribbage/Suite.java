package sdm.cribbage;

import java.util.HashMap;
import java.util.Map;

public enum Suite {
    DIAMONDS, HEARTS, CLUBS, SPADES;
    
    private static Map<Character, Suite> suitesByChar = new HashMap<>(){{
        put('♦', Suite.DIAMONDS);
        put('♥', Suite.HEARTS);
        put('♣', Suite.CLUBS);
        put('♠', Suite.SPADES);
    }};

    public static Suite valueOf(char suiteAsChar) {
        return suitesByChar.get(suiteAsChar);
    }
}
