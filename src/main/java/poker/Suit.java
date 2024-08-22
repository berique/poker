package poker;

public enum Suit {
    SPADES("♠\uFE0F"),
    HEARTS("♥\uFE0F"),
    DIAMONDS("♦\uFE0F"),
    CLUBS("♣\uFE0F"),
    ;

    private final String suit;

    Suit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return suit;
    }
}
