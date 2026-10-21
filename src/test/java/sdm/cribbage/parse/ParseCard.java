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

    @Test
    void withSuiteDiamonds() {
        assertEquals(Suite.DIAMONDS, Card.parse("0♦").suite());
    }

    @Test
    void withSuiteClubs() {
        assertEquals(Suite.CLUBS, Card.parse("7♣").suite());
    }

    @Test
    void withSuiteSpades() {
        assertEquals(Suite.SPADES, Card.parse("Q♠").suite());
    }

    @Test
    void withRankFive() {
        assertEquals('5', Card.parse("5♥").rank());
    }

    @Test
    void withRankTen() {
        assertEquals('0', Card.parse("0♦").rank());
    }

    @Test
    void withRankAceAndSuiteSpades() {
        assertEquals(new Card('A', Suite.SPADES), Card.parse("A♠"));
    }
}
