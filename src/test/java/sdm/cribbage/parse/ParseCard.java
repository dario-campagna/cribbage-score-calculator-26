package sdm.cribbage.parse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import sdm.cribbage.Card;
import sdm.cribbage.Rank;
import sdm.cribbage.Suit;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParseCard {

    public static Stream<Arguments> cardAndStringProvider() {
        return Stream.of(
                Arguments.arguments(new Card(Rank.FIVE, Suit.HEARTS), "5♥"),
                Arguments.arguments(new Card(Rank.TEN, Suit.DIAMONDS), "0♦"),
                Arguments.arguments(new Card(Rank.SEVEN, Suit.CLUBS), "7♣"),
                Arguments.arguments(new Card(Rank.QUEEN, Suit.SPADES), "Q♠"),
                Arguments.arguments(new Card(Rank.ACE, Suit.SPADES), "A♠")
        );
    }

    @ParameterizedTest
    @MethodSource("cardAndStringProvider")
    void fromString(Card expectedCard, String cardAsString) {
        assertEquals(expectedCard, Card.parse(cardAsString));
    }

    @Test
    void withUnknownRank() {
        assertThrows(IllegalArgumentException.class, () -> Card.parse("X♥"));
    }

    @Test
    void withUnknownSuit() {
        assertThrows(IllegalArgumentException.class, () -> Card.parse("5X"));
    }

}
