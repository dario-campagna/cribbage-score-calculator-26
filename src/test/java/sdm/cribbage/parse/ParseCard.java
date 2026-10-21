package sdm.cribbage.parse;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import sdm.cribbage.Card;
import sdm.cribbage.Suit;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseCard {

    public static Stream<Arguments> cardAndStringProvider() {
        return Stream.of(
                Arguments.arguments(new Card('5', Suit.HEARTS), "5♥"),
                Arguments.arguments(new Card('0', Suit.DIAMONDS), "0♦"),
                Arguments.arguments(new Card('7', Suit.CLUBS), "7♣"),
                Arguments.arguments(new Card('Q', Suit.SPADES), "Q♠"),
                Arguments.arguments(new Card('A', Suit.SPADES), "A♠")
        );
    }

    @ParameterizedTest
    @MethodSource("cardAndStringProvider")
    void fromString(Card expectedCard, String cardAsString) {
        assertEquals(expectedCard, Card.parse(cardAsString));
    }

}
