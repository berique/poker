package poker;

public enum Rank {
    ACE((short) 14, "A"),
    KING((short) 13, "K"),
    QUEEN((short) 12, "Q"),
    JACK((short) 11, "J"),
    TEN((short) 10, "10"),
    NINE((short) 9, "9"),
    EIGHT((short) 8, "8"),
    SEVEN((short) 7, "7"),
    SIX((short) 6, "6"),
    FIVE((short) 5, "5"),
    FOUR((short) 4, "4"),
    THREE((short) 3, "3"),
    DEUCE((short) 2, "2"),
    ;

    private final short value;
    private final String ch;

    public short getValue() {
        return value;
    }

    Rank(short value, String ch) {
        this.value = value;
        this.ch = ch;
    }

    @Override
    public String toString() {
        return this.ch;
    }
}
