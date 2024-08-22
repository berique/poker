package poker.evaluate;

import poker.Card;
import poker.Rank;
import poker.Suit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlushEvaluate extends AbstractEvaluate {
    @Override
    public Boolean evaluate(List<Card> playerHand, List<Card> flop) {
        List<Card> union = union(playerHand, flop);
        Map<Suit, List<Rank>> map = new HashMap<>();
        for (Card card : union) {
            map.computeIfAbsent(card.getSuit(), k -> new ArrayList<>());
            map.get(card.getSuit()).add(card.getRank());
        }
        for (Suit keySet : map.keySet()) {
            if (map.get(keySet).size() == 5) {
                return true;
            }
        }
        return false;
    }
}
