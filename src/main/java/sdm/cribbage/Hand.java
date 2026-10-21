package sdm.cribbage;

public class Hand {
    private final Card starterCard;

    public Hand(Card starterCard) {
        this.starterCard = starterCard;
    }

    public static Hand parse(String handAsString) {
        String starterCardAsString = handAsString.substring(handAsString.length() - 2);
        return new Hand(Card.parse(starterCardAsString));
    }

    public Card starterCard() {
        return starterCard;
    }
}
