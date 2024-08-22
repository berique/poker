package poker;

public enum Phase {
    CHALLENGE(0),
    FLOP(3),
    TURN(1),
    RIVER(1),
    ;

    private final int qty;

    Phase(int qty) {
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }
}
