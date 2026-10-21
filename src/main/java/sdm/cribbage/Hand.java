package sdm.cribbage;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> handCards;
    private final Card starterCard;

    public Hand(List<Card> handCards, Card starterCard) {
        this.handCards = handCards;
        this.starterCard = starterCard;
    }

    public static Hand parse(String handAsString) {
        List<Card> handCards = parseHandCards(handAsString);
        String starterCardAsString = parseStarterCard(handAsString);
        return new Hand(handCards, Card.parse(starterCardAsString));
    }

    private static String parseStarterCard(String handAsString) {
        String starterCardAsString = handAsString.substring(handAsString.length() - 2);
        return starterCardAsString;
    }

    private static List<Card> parseHandCards(String handAsString) {
        List<Card> handCards = new ArrayList<>();
        String handCardsAsString = handAsString.substring(0, handAsString.length() - 2);
        for (int i = 1; i < handCardsAsString.length(); i += 2) {
            handCards.add(Card.parse(handCardsAsString.substring(i - 1, i + 1)));
        }
        return handCards;
    }

    public Card starterCard() {
        return starterCard;
    }

    public List<Card> handCards() {
        return handCards;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Hand hand)) return false;

        return handCards.equals(hand.handCards) && starterCard.equals(hand.starterCard);
    }

    @Override
    public int hashCode() {
        int result = handCards.hashCode();
        result = 31 * result + starterCard.hashCode();
        return result;
    }
}
