package sdm.cribbage.parse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sdm.cribbage.Suit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParseSuit {

    @ParameterizedTest
    @CsvSource({
            "♦, DIAMONDS",
            "♥, HEARTS",
            "♣, CLUBS",
            "♠, SPADES"
    })
    void fromSymbol(char suitAsChar, Suit expectedSuit) {
        assertEquals(expectedSuit, Suit.of(suitAsChar));
    }

    @Test
    void withUnknownSymbol() {
        assertThrows(IllegalArgumentException.class, () -> Suit.of('X'));
    }
}
