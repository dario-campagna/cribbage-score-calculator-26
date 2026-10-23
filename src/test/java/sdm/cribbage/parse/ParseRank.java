package sdm.cribbage.parse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sdm.cribbage.Rank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParseRank {

    @ParameterizedTest
    @CsvSource({
            "A, ACE",
            "2, TWO",
            "3, THREE",
            "4, FOUR",
            "5, FIVE",
            "6, SIX",
            "7, SEVEN",
            "8, EIGHT",
            "9, NINE",
            "0, TEN",
            "J, JACK",
            "Q, QUEEN",
            "K, KING"
    })
    void fromSymbol(char rankAsChar, Rank expectedRank) {
        assertEquals(expectedRank, Rank.of(rankAsChar));
    }

    @Test
    void withUnknownSymbol() {
        assertThrows(IllegalArgumentException.class, () -> Rank.of('X'));
    }

    @Test
    void withLowercaseSymbol() {
        assertThrows(IllegalArgumentException.class, () -> Rank.of('k'));
    }
}
