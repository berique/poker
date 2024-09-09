package poker.evaluate;

import poker.Card;
import poker.Rank;
import poker.Suit;

import java.util.Arrays;
import java.util.List;

public class StraightFlushEvaluate extends AbstractEvaluate {
    @Override
    public Boolean evaluate(List<Card> playerHand, List<Card> community) {
        return new StraightEvaluate().evaluate(playerHand, community) && new FlushEvaluate().evaluate(playerHand, community);
    }

}
