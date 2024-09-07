package poker;

public enum Phase {
    PRE_FLOP(0),
    FLOP(3),
    TURN(1),
    RIVER(1),
    ;

    private final int totalCards;

    Phase(int totalCards) {
        this.totalCards = totalCards;
    }

    public int getTotalCards() {
        return totalCards;
    }
}
