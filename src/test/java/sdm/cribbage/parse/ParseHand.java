package sdm.cribbage.parse;

import org.junit.jupiter.api.Test;
import sdm.cribbage.Card;
import sdm.cribbage.Hand;
import sdm.cribbage.Suit;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseHand {

    @Test
    void withStarterCardFiveOfClubs() {
        Hand parsedHand = Hand.parse("5♥5♦5♠J♣5♣");
        assertEquals(new Card('5', Suit.CLUBS), parsedHand.starterCard());
    }

    @Test
    void withStarterCardSevenOfSpades() {
        Hand parsedHand = Hand.parse("5♥5♦5♠J♣7♠");
        assertEquals(new Card('7', Suit.SPADES), parsedHand.starterCard());
    }

    @Test
    void withHandCardsKingOfAllSuits() {
        Hand parsedHand = Hand.parse("K♥K♦K♠K♣J♠");
        List<Card> expectedHandCards = Arrays.asList(
                new Card('K', Suit.HEARTS),
                new Card('K', Suit.DIAMONDS),
                new Card('K', Suit.SPADES),
                new Card('K', Suit.CLUBS)
        );
        assertEquals(expectedHandCards, parsedHand.handCards());
    }

    @Test
    void withAllDifferentCards() {
        List<Card> expectedHandCards = Arrays.asList(
                new Card('A', Suit.HEARTS),
                new Card('2', Suit.DIAMONDS),
                new Card('3', Suit.SPADES),
                new Card('4', Suit.CLUBS)
        );
        Hand expectedHand = new Hand(expectedHandCards, new Card('5', Suit.SPADES));
        Hand parsedHand = Hand.parse("A♥2♦3♠4♣5♠");
        assertEquals(expectedHand, parsedHand);
    }
}
