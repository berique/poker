package poker.evaluate;

import poker.Card;
import poker.Rank;
import poker.Suit;

import java.util.*;

public class TwoPairEvaluate extends AbstractEvaluate {
    @Override
    public Boolean evaluate(List<Card> playerHand, List<Card> community) {
        List<Card> union = new LinkedList<>(playerHand);
        union.addAll(community);
        Map<Rank, List<Suit>> map = new HashMap<>();
        for (Card card : union) {
            map.computeIfAbsent(card.getRank(), k -> new ArrayList<>());
            map.get(card.getRank()).add(card.getSuit());
        }
        boolean haveOnePair = false;
        boolean haveTwoPair = false;
        for (Rank keySet : map.keySet()) {
            if (map.get(keySet).size() == 2) {
                if (!haveOnePair) {
                    haveOnePair = true;
                } else {
                    haveTwoPair = true;
                    break;
                }
            }
        }
        return haveOnePair && haveTwoPair;
    }
}
