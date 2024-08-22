package poker.evaluate;

import poker.Card;
import poker.Rank;

import java.util.Arrays;
import java.util.List;

public class StraightEvaluate extends AbstractEvaluate {
    @Override
    public Boolean evaluate(List<Card> playerHand, List<Card> flop) {
        Card[] allCards = unionArray(playerHand, flop);
        Arrays.sort(allCards, byRank);
        int noOfCardsInARow = 0;
        boolean hasAce = false;
        for (Card card: playerHand) {
            if (card.getRank() == Rank.ACE) {
                hasAce = true;
                break;
            }
        }
        for (int pos = 0; pos < allCards.length - 1; pos++) {
            short value1 = allCards[pos + 1].getRank().getValue();
            short value2 = allCards[pos].getRank().getValue();
            if (value1 - value2 == 1) {
                noOfCardsInARow++;
                if ( noOfCardsInARow == 2 && value1 == 4 && hasAce ) {
                    return true;
                } else if (noOfCardsInARow == 4) {
                    return true;
                }
            } else {
                noOfCardsInARow = 0;
            }
        }
        return false;
    }
}
