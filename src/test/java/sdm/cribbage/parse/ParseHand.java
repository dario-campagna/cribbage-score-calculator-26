package sdm.cribbage.parse;

import org.junit.jupiter.api.Test;
import sdm.cribbage.Card;
import sdm.cribbage.Hand;
import sdm.cribbage.Rank;
import sdm.cribbage.Suit;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseHand {

    @Test
    void withStarterCardFiveOfClubs() {
        Hand parsedHand = Hand.parse("5♥5♦5♠J♣5♣");
        assertEquals(new Card(Rank.FIVE, Suit.CLUBS), parsedHand.starterCard());
    }

    @Test
    void withStarterCardSevenOfSpades() {
        Hand parsedHand = Hand.parse("5♥5♦5♠J♣7♠");
        assertEquals(new Card(Rank.SEVEN, Suit.SPADES), parsedHand.starterCard());
    }

    @Test
    void withHandCardsKingOfAllSuits() {
        Hand parsedHand = Hand.parse("K♥K♦K♠K♣J♠");
        List<Card> expectedHandCards = Arrays.asList(
                new Card(Rank.KING, Suit.HEARTS),
                new Card(Rank.KING, Suit.DIAMONDS),
                new Card(Rank.KING, Suit.SPADES),
                new Card(Rank.KING, Suit.CLUBS)
        );
        assertEquals(expectedHandCards, parsedHand.handCards());
    }

    @Test
    void withAllDifferentCards() {
        List<Card> expectedHandCards = Arrays.asList(
                new Card(Rank.ACE, Suit.HEARTS),
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.THREE, Suit.SPADES),
                new Card(Rank.FOUR, Suit.CLUBS)
        );
        Hand expectedHand = new Hand(expectedHandCards, new Card(Rank.FIVE, Suit.SPADES));
        Hand parsedHand = Hand.parse("A♥2♦3♠4♣5♠");
        assertEquals(expectedHand, parsedHand);
    }
}
