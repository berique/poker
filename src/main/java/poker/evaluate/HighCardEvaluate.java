package poker.evaluate;

import poker.Card;

import java.util.List;

public class HighCardEvaluate extends AbstractEvaluate {
    @Override
    public Boolean evaluate(List<Card> playerHand, List<Card> flop) {
        return true;
    }
}
