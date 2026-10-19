package sdm.cribbage.parse;

import org.junit.jupiter.api.Test;
import sdm.cribbage.Card;
import sdm.cribbage.Suite;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseCard {

    @Test
    void withSuiteHearts() {
        assertEquals(Suite.HEARTS, Card.parse("5♥").suite());
    }
}
