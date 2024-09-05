package poker.evaluate;

import org.junit.jupiter.api.Test;
import poker.Card;
import poker.Rank;
import poker.Suit;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlushEvaluateTest {

    @Test
    void evaluate() {
        List<Card> hands = new ArrayList<>();
        hands.add(new Card(Rank.DEUCE, Suit.CLUBS));
        hands.add(new Card(Rank.THREE, Suit.CLUBS));

        List<Card> board = new ArrayList<>();
        board.add(new Card(Rank.SIX, Suit.CLUBS));
        board.add(new Card(Rank.KING, Suit.CLUBS));
        board.add(new Card(Rank.QUEEN, Suit.CLUBS));

        assertEquals(true, new FlushEvaluate().evaluate(hands, board));
    }

    @Test
    void evaluate2() {
        List<Card> hands = new ArrayList<>();
        hands.add(new Card(Rank.DEUCE, Suit.SPADES));
        hands.add(new Card(Rank.THREE, Suit.CLUBS));

        List<Card> board = new ArrayList<>();
        board.add(new Card(Rank.SIX, Suit.CLUBS));
        board.add(new Card(Rank.KING, Suit.CLUBS));
        board.add(new Card(Rank.QUEEN, Suit.CLUBS));

        assertFalse(new FlushEvaluate().evaluate(hands, board));
    }
}