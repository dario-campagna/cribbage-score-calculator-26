package sdm.cribbage;

import java.util.Arrays;
import java.util.List;

public class Hand {
    private final List<Card> handCards;
    private final Card starterCard;

    public Hand(List<Card> handCards, Card starterCard) {
        this.handCards = handCards;
        this.starterCard = starterCard;
    }

    public static Hand parse(String handAsString) {
        List<Card> handCards = Arrays.asList(
                new Card('K', Suite.HEARTS),
                new Card('K', Suite.DIAMONDS),
                new Card('K', Suite.SPADES),
                new Card('K', Suite.CLUBS)
        );
        String starterCardAsString = handAsString.substring(handAsString.length() - 2);
        return new Hand(handCards, Card.parse(starterCardAsString));
    }

    public Card starterCard() {
        return starterCard;
    }

    public List<Card> handCards() {
        return handCards;
    }
}
