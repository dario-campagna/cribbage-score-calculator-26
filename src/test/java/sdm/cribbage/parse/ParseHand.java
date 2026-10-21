package sdm.cribbage.parse;

import org.junit.jupiter.api.Test;
import sdm.cribbage.Card;
import sdm.cribbage.Hand;
import sdm.cribbage.Suite;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseHand {

    @Test
    void withStarterCardFiveOfClubs() {
        Hand parsedHand = Hand.parse("5♥5♦5♠J♣5♣");
        assertEquals(new Card('5', Suite.CLUBS), parsedHand.starterCard());
    }

    @Test
    void withStarterCardSevenOfSpades() {
        Hand parsedHand = Hand.parse("5♥5♦5♠J♣7♠");
        assertEquals(new Card('7', Suite.SPADES), parsedHand.starterCard());
    }

    @Test
    void withHandCardsKingOfAllSuites() {
        Hand parsedHand = Hand.parse("K♥K♦K♠K♣J♠");
        List<Card> expectedHandCards = Arrays.asList(
                new Card('K', Suite.HEARTS),
                new Card('K', Suite.DIAMONDS),
                new Card('K', Suite.SPADES),
                new Card('K', Suite.CLUBS)
        );
        assertEquals(expectedHandCards, parsedHand.handCards());
    }

    @Test
    void withAllDifferentCards() {
        List<Card> expectedHandCards = Arrays.asList(
                new Card('A', Suite.HEARTS),
                new Card('2', Suite.DIAMONDS),
                new Card('3', Suite.SPADES),
                new Card('4', Suite.CLUBS)
        );
        Hand expetedHand = new Hand(expectedHandCards, new Card('5', Suite.SPADES));
        Hand parsedHand = Hand.parse("A♥2♦3♠4♣5♠");
        assertEquals(expetedHand, parsedHand);
    }
}
