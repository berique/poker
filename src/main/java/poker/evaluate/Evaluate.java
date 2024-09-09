package poker.evaluate;

import poker.Card;

import java.util.List;

public interface Evaluate {
    Boolean evaluate(List<Card> playerHand, List<Card> community);
}
