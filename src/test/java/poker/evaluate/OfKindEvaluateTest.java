package poker.evaluate;

import poker.Card;
import poker.Rank;
import poker.Suit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OfKindEvaluateTest {
    OfKindEvaluate ofKindEvaluate = new OfKindEvaluate(4);

    @Test
    public void evaluate() {
        List<Card> hands = new ArrayList<>();
        hands.add(new Card(Rank.TEN, Suit.DIAMONDS));
        hands.add(new Card(Rank.TEN, Suit.HEARTS));

        List<Card> board = new ArrayList<>();
        board.add(new Card(Rank.TEN, Suit.SPADES));
        board.add(new Card(Rank.TEN, Suit.CLUBS));
        board.add(new Card(Rank.KING, Suit.CLUBS));

        assertTrue(ofKindEvaluate.evaluate(hands, board));
    }

    @Test
    public void evaluate2() {
        List<Card> hands = new ArrayList<>();
        hands.add(new Card(Rank.TEN, Suit.DIAMONDS));
        hands.add(new Card(Rank.TEN, Suit.HEARTS));

        List<Card> board = new ArrayList<>();
        board.add(new Card(Rank.NINE, Suit.SPADES));
        board.add(new Card(Rank.TEN, Suit.CLUBS));
        board.add(new Card(Rank.KING, Suit.CLUBS));

        assertFalse(ofKindEvaluate.evaluate(hands, board));
    }
}