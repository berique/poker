package poker.evaluate;

import poker.Card;
import poker.Rank;
import poker.Suit;

import java.util.Arrays;
import java.util.List;

public class RoyalFlushEvaluate extends AbstractEvaluate {
    @Override
    public Boolean evaluate(List<Card> playerHand, List<Card> flop) {
        Card[] union = unionArray(playerHand, flop);
        Arrays.sort(union, byRank);

        boolean ace = false, //
                king = false, //
                queen = false, //
                jack = false, //
                ten = false;
        Suit suit = null;
        for (Card card : union) {
            if (suit == null) {
                suit = card.getSuit();
            }
            if (suit == card.getSuit()) {
                switch (card.getRank()) {
                    case Rank.ACE:
                        ace = true;
                        break;
                    case Rank.KING:
                        king = true;
                        break;
                    case Rank.QUEEN:
                        queen = true;
                        break;
                    case Rank.JACK:
                        jack = true;
                        break;
                    case Rank.TEN:
                        ten = true;
                        break;
                }
            }
            suit = card.getSuit();
        }
        return ace && king && queen && jack && ten;
    }
}
