package poker.evaluate;

import poker.Card;
import poker.Rank;

import java.util.Arrays;
import java.util.List;

public class StraightEvaluate extends AbstractEvaluate {
    @Override
    public Boolean evaluate(List<Card> playerHand, List<Card> community) {
        Card[] allCards = unionList(playerHand, community);
        Arrays.sort(allCards, byRank);
        int noOfCardsInARow = 0;
        boolean hasAce = false;
        for (Card card: allCards) {
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
                if (noOfCardsInARow == 3 && value1 == 5 && hasAce) {
                    return true;
                }
                if (noOfCardsInARow == 4) {
                    return true;
                }
            } else {
                noOfCardsInARow = 0;
            }
        }
        return false;
    }
}
