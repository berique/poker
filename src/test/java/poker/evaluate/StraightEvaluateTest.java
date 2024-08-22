package poker.evaluate;

import poker.Card;
import poker.Rank;
import poker.Suit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StraightEvaluateTest {

    @Test
    void evaluate() {
        List<Card> hands = new ArrayList<>();
        hands.add(new Card(Rank.TEN, Suit.DIAMONDS));
        hands.add(new Card(Rank.NINE, Suit.HEARTS));

        List<Card> board = new ArrayList<>();
        board.add(new Card(Rank.EIGHT, Suit.SPADES));
        board.add(new Card(Rank.SEVEN, Suit.CLUBS));
        board.add(new Card(Rank.SIX, Suit.CLUBS));

        assertTrue(new StraightEvaluate().evaluate(hands, board));
    }

    @Test
    void evaluate1() {
        List<Card> hands = new ArrayList<>();
        hands.add(new Card(Rank.TEN, Suit.DIAMONDS));
        hands.add(new Card(Rank.NINE, Suit.HEARTS));

        List<Card> board = new ArrayList<>();
        board.add(new Card(Rank.EIGHT, Suit.SPADES));
        board.add(new Card(Rank.FOUR, Suit.CLUBS));
        board.add(new Card(Rank.SIX, Suit.CLUBS));

        assertFalse(new StraightEvaluate().evaluate(hands, board));
    }

    @Test
    void evaluate2() {
        List<Card> hands = new ArrayList<>();
        hands.add(new Card(Rank.TEN, Suit.DIAMONDS));
        hands.add(new Card(Rank.NINE, Suit.HEARTS));

        List<Card> board = new ArrayList<>();
        board.add(new Card(Rank.EIGHT, Suit.SPADES));
        board.add(new Card(Rank.FOUR, Suit.CLUBS));
        board.add(new Card(Rank.SIX, Suit.CLUBS));

        assertFalse(new StraightEvaluate().evaluate(hands, board));
    }
}