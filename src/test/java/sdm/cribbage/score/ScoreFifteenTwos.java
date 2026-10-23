package sdm.cribbage.score;

import org.junit.jupiter.api.Test;
import sdm.cribbage.Hand;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreFifteenTwos {

    @Test
    void noFifteen() {
        Hand hand = Hand.parse("A♥A♦2♠2♣3♣");
        assertEquals(0, hand.scoreFifteenTwos());
    }

    @Test
    void oneFifteenWithTwoCards() {
        Hand hand = Hand.parse("5♥Q♦A♠7♣6♠");
        assertEquals(2, hand.scoreFifteenTwos());
    }

    @Test
    void twoFifteensWithTenAndJack() {
        Hand hand = Hand.parse("5♥0♦J♠2♣A♣");
        assertEquals(4, hand.scoreFifteenTwos());
    }

    @Test
    void fourFifteensWithFaceCardsAndTen() {
        Hand hand = Hand.parse("K♥Q♦J♠0♣5♣");
        assertEquals(8, hand.scoreFifteenTwos());
    }

    @Test
    void oneFifteenWithAllFiveCards() {
        Hand hand = Hand.parse("A♥2♦3♠4♣5♣");
        assertEquals(2, hand.scoreFifteenTwos());
    }

    @Test
    void eightFifteensWithFourFivesAndJack() {
        Hand hand = Hand.parse("5♥5♦5♠J♣5♣");
        assertEquals(16, hand.scoreFifteenTwos());
    }
}
