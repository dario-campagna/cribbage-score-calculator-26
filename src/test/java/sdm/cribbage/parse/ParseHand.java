package sdm.cribbage.parse;

import org.junit.jupiter.api.Test;
import sdm.cribbage.Hand;
import sdm.cribbage.Suite;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseHand {

    @Test
    void withStarterCardFiveOfClubs() {
        Hand parsedHand = Hand.parse("5♥5♦5♠J♣5♣");
        assertAll(
                () -> assertEquals('5', parsedHand.starterCard().rank()),
                () -> assertEquals(Suite.CLUBS, parsedHand.starterCard().suite())
        );
    }
}
