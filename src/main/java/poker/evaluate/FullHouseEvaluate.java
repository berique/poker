package poker.evaluate;

import poker.Card;
import poker.Rank;
import poker.Suit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FullHouseEvaluate extends AbstractEvaluate {
    @Override
    public Boolean evaluate(List<Card> playerHand, List<Card> flop) {
        List<Card> union = union(playerHand, flop);
        Map<Rank, List<Suit>> map = new HashMap<>();
        boolean twoOfKind = false, //
                threeOfKind = false;
        for (Card card : union) {
            map.computeIfAbsent(card.getRank(), k -> new ArrayList<>());
            map.get(card.getRank()).add(card.getSuit());
        }
        for (Rank keySet : map.keySet()) {
            List<Suit> suits = map.get(keySet);
            if (suits.size() == 3 && !threeOfKind) {
                threeOfKind = true;
            } else if (suits.size() == 2) {
                twoOfKind = true;
            }
        }
        return threeOfKind && twoOfKind;
    }
}
