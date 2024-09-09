package poker.evaluate;

import poker.Card;
import poker.Rank;
import poker.Suit;

import java.util.*;

public class OfKindEvaluate extends AbstractEvaluate {
    private final int quantity;

    private OfKindEvaluate() {
        this.quantity = 0;
    }

    public OfKindEvaluate(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public Boolean evaluate(List<Card> playerHand, List<Card> community) {
        List<Card> union = union(playerHand, community);
        Map<Rank, List<Suit>> map = new HashMap<>();
        for (Card card : union) {
            map.computeIfAbsent(card.getRank(), k -> new ArrayList<>());
            map.get(card.getRank()).add(card.getSuit());
        }
        for (Rank keySet : map.keySet()) {
            if (map.get(keySet).size() == this.quantity) {
                return true;
            }
        }
        return false;
    }
}
