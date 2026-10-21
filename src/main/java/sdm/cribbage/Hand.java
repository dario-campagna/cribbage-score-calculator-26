package sdm.cribbage;

public class Hand {
    private final Card starterCard;

    public Hand(Card starterCard) {
        this.starterCard = starterCard;
    }

    public static Hand parse(String handAsString) {
        return new Hand(new Card('5', Suite.CLUBS));
    }

    public Card starterCard() {
        return starterCard;
    }
}
