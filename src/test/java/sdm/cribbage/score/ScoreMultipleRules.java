package sdm.cribbage.score;

import org.junit.jupiter.api.Test;
import sdm.cribbage.Hand;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreMultipleRules {

    @Test
    void twoPairsAndFiveFifteenTwos() {
        Hand hand = Hand.parse("7♥7♦8♠8♣A♥");
        assertEquals(14, hand.score());
    }

    @Test
    void onePairAndTwoFifteenTwos() {
        Hand hand = Hand.parse("5♥5♦0♠A♣2♣");
        assertEquals(6, hand.score());
    }
}
