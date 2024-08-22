package poker;

import java.util.List;

public interface Evaluate {
    Boolean evaluate(List<Card> playerHand, List<Card> flop);
}
