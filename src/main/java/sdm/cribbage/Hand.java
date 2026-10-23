package sdm.cribbage;

import org.paukov.combinatorics3.Generator;

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
        return handAsString.substring(handAsString.length() - 2);
    }

    private static List<Card> parseHandCards(String handAsString) {
        List<Card> handCards = new ArrayList<>();
        String handCardsAsString = handAsString.substring(0, handAsString.length() - 2);
        for (int i = 0; i < handCardsAsString.length(); i += 2) {
            handCards.add(Card.parse(handCardsAsString.substring(i, i + 2)));
        }
        return handCards;
    }

    public int scorePairs() {
        return Generator.combination(allCards()).simple(2).stream()
                .filter(twoCards -> twoCards.getFirst().hasSameRankAs(twoCards.getLast()))
                .mapToInt(pair -> 2)
                .sum();
    }

    private List<Card> allCards() {
        List<Card> allCards = new ArrayList<>(handCards);
        allCards.add(starterCard);
        return allCards;
    }

    public int scoreFifteenTwos() {
        return Generator.subset(allCards()).simple().stream()
                .filter(combination -> sumOfValues(combination) == 15)
                .mapToInt(fifteen -> 2)
                .sum();
    }

    private int sumOfValues(List<Card> cards) {
        return cards.stream()
                .mapToInt(card -> valueOf(card.rank()))
                .sum();
    }

    private int valueOf(char rank) {
        return switch (rank) {
            case 'A' -> 1;
            case '0', 'J', 'Q', 'K' -> 10;
            default -> rank - '0';
        };
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
