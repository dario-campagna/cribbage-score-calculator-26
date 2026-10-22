package sdm.cribbage.score;

import org.junit.jupiter.api.Test;
import sdm.cribbage.Hand;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScorePairs {

    @Test
    void onePair() {
        Hand hand = Hand.parse("5♥5♦A♠2♣6♣");
        assertEquals(2, hand.scorePairs());
    }

    @Test
    void threeDistinctPairs() {
        Hand hand = Hand.parse("A♥A♦A♠2♣6♣");
        assertEquals(6, hand.scorePairs());
    }

    @Test
    void sixDistinctPairs() {
        Hand hand = Hand.parse("6♥Q♦Q♠Q♣Q♥");
        assertEquals(12, hand.scorePairs());
    }
}
