package poker.evaluate;

import org.junit.jupiter.api.Test;
import poker.Card;
import poker.Rank;
import poker.Suit;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StraightFlushEvaluateTest {

    @Test
    public void evaluate() {
        List<Card> hands = new ArrayList<>();
        hands.add(new Card(Rank.DEUCE, Suit.CLUBS));
        hands.add(new Card(Rank.THREE, Suit.CLUBS));

        List<Card> board = new ArrayList<>();
        board.add(new Card(Rank.FOUR, Suit.CLUBS));
        board.add(new Card(Rank.FIVE, Suit.CLUBS));
        board.add(new Card(Rank.SIX, Suit.CLUBS));

        assertTrue(new StraightFlushEvaluate().evaluate(hands, board));
    }

    @Test
    public void evaluate2() {
        List<Card> hands = new ArrayList<>();
        hands.add(new Card(Rank.DEUCE, Suit.CLUBS));
        hands.add(new Card(Rank.THREE, Suit.CLUBS));

        List<Card> board = new ArrayList<>();
        board.add(new Card(Rank.FOUR, Suit.DIAMONDS));
        board.add(new Card(Rank.FIVE, Suit.CLUBS));
        board.add(new Card(Rank.SIX, Suit.CLUBS));

        assertFalse(new StraightFlushEvaluate().evaluate(hands, board));
    }

    @Test
    public void evaluate3() {
        List<Card> hands = new ArrayList<>();
        hands.add(new Card(Rank.DEUCE, Suit.CLUBS));
        hands.add(new Card(Rank.THREE, Suit.CLUBS));

        List<Card> board = new ArrayList<>();
        board.add(new Card(Rank.KING, Suit.CLUBS));
        board.add(new Card(Rank.FIVE, Suit.CLUBS));
        board.add(new Card(Rank.SIX, Suit.CLUBS));

        assertFalse(new StraightFlushEvaluate().evaluate(hands, board));
    }

    @Test
    public void evaluate4() {
        List<Card> hands = new ArrayList<>();
        hands.add(new Card(Rank.ACE, Suit.CLUBS));
        hands.add(new Card(Rank.THREE, Suit.CLUBS));

        List<Card> board = new ArrayList<>();
        board.add(new Card(Rank.DEUCE, Suit.CLUBS));
        board.add(new Card(Rank.FIVE, Suit.CLUBS));
        board.add(new Card(Rank.FOUR, Suit.CLUBS));

        assertTrue(new StraightFlushEvaluate().evaluate(hands, board));
    }
}