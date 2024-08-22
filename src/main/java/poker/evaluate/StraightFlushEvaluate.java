package poker.evaluate;

import poker.Card;
import poker.Rank;
import poker.Suit;

import java.util.Arrays;
import java.util.List;

public class StraightFlushEvaluate extends AbstractEvaluate {
    @Override
    public Boolean evaluate(List<Card> playerHand, List<Card> flop) {
        return new StraightEvaluate().evaluate(playerHand, flop) && new FlushEvaluate().evaluate(playerHand, flop);
    }

}
