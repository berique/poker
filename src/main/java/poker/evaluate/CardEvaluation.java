package poker.evaluate;

public enum CardEvaluation {
    ROYAL_FLUSH(new RoyalFlushEvaluate()), //
    STRAIGHT_FLUSH(new StraightFlushEvaluate()), //
    FOUR_OF_A_KIND(new OfKindEvaluate(4)), //
    FULL_HOUSE(new FullHouseEvaluate()), //
    FLUSH(new FlushEvaluate()), //
    STRAIGHT(new StraightEvaluate()), //
    THREE_OF_A_KIND(new OfKindEvaluate(3)), //
    TWO_PAIR(new TwoPairEvaluate()), //
    ONE_PAIR(new OfKindEvaluate(2)),
    HIGH_CARD(new HighCardEvaluate()),
    ;


    private final Evaluate evaluate;

    CardEvaluation(Evaluate evaluate) {
        this.evaluate = evaluate;
    }

    public Evaluate getEvaluate() {
        return evaluate;
    }
}
