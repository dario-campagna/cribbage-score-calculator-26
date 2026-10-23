package sdm.cribbage.score;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sdm.cribbage.Rank;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankValue {

    @ParameterizedTest
    @CsvSource({
            "ACE, 1",
            "TWO, 2",
            "THREE, 3",
            "FOUR, 4",
            "FIVE, 5",
            "SIX, 6",
            "SEVEN, 7",
            "EIGHT, 8",
            "NINE, 9",
            "TEN, 10",
            "JACK, 10",
            "QUEEN, 10",
            "KING, 10"
    })
    void ofEachRank(Rank rank, int expectedValue) {
        assertEquals(expectedValue, rank.value());
    }
}
