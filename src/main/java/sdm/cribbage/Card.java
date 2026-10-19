package sdm.cribbage;

public class Card {
    public static Card parse(String cardAsString) {
        return new Card();
    }

    public Suite suite() {
        return Suite.HEARTS;
    }
}
