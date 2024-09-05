package poker;

public enum PokerType {
    TEXAS_HOLDEN(2, 9),
    ;

    private final int totalCards;
    private final int totalPlayers;

    PokerType(int totalCards, int totalPlayers) {
        this.totalCards = totalCards;
        this.totalPlayers = totalPlayers;
    }

    public int getTotalCards() {
        return totalCards;
    }

    public int getTotalPlayers() {
        return totalPlayers;
    }
}
