package poker.evaluate;

import poker.Card;
import poker.Evaluate;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public abstract class AbstractEvaluate implements Evaluate {
    protected Comparator<Card> byRank = (Card left, Card right) -> {
        if (left.getRank().getValue() < right.getRank().getValue()) {
            return -1;
        } else {
            return 1;
        }
    };

    protected Comparator<Card> byRankDesc = (Card left, Card right) -> {
        if (left.getRank().getValue() < right.getRank().getValue()) {
            return 1;
        } else {
            return -1;
        }
    };

    protected List<Card> union(List<Card> a, List<Card> b) {
        return Stream.concat(a.stream(), b.stream()).toList();
    }

    public Card[] unionList(List<Card> a, List<Card> b) {
        return Stream.concat(a.stream(), b.stream()).toArray(Card[]::new);
    }

}
