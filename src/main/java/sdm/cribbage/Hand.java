package sdm.cribbage;

import org.paukov.combinatorics3.Generator;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private static final int CARD_STRING_LENGTH = 2;
    private static final int POINTS_FOR_PAIR = 2;
    private static final int FIFTEEN = 15;
    private static final int POINTS_FOR_FIFTEEN = 2;
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
        return handAsString.substring(handAsString.length() - CARD_STRING_LENGTH);
    }

    private static List<Card> parseHandCards(String handAsString) {
        List<Card> handCards = new ArrayList<>();
        String handCardsAsString = handAsString.substring(0, handAsString.length() - CARD_STRING_LENGTH);
        for (int i = 0; i < handCardsAsString.length(); i += CARD_STRING_LENGTH) {
            handCards.add(Card.parse(handCardsAsString.substring(i, i + CARD_STRING_LENGTH)));
        }
        return handCards;
    }

    public int score() {
        return scorePairs() + scoreFifteenTwos();
    }

    public int scorePairs() {
        return Generator.combination(allCards()).simple(2).stream()
                .filter(twoCards -> twoCards.getFirst().hasSameRankAs(twoCards.getLast()))
                .mapToInt(pair -> POINTS_FOR_PAIR)
                .sum();
    }

    private List<Card> allCards() {
        List<Card> allCards = new ArrayList<>(handCards);
        allCards.add(starterCard);
        return allCards;
    }

    public int scoreFifteenTwos() {
        return Generator.subset(allCards()).simple().stream()
                .filter(combination -> sumOfValues(combination) == FIFTEEN)
                .mapToInt(fifteen -> POINTS_FOR_FIFTEEN)
                .sum();
    }

    private int sumOfValues(List<Card> cards) {
        return cards.stream()
                .mapToInt(Card::value)
                .sum();
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
