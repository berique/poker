package poker;

import poker.evaluate.CardEvaluation;

import java.util.List;

public class CardValidation {
    public static CardEvaluation validate(List<Card> player, List<Card> flop) {
        for (CardEvaluation cardEvaluation : CardEvaluation.values()) {
            if (cardEvaluation.getEvaluate().evaluate(player, flop)) {
                return cardEvaluation;
            }
        }
        throw new RuntimeException("No evaluation");
    }
}
