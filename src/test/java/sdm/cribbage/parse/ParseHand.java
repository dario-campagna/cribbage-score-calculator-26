package sdm.cribbage.parse;

import org.junit.jupiter.api.Test;
import sdm.cribbage.Card;
import sdm.cribbage.Hand;
import sdm.cribbage.Suite;

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
}
