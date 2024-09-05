package poker.evaluate;

import org.junit.jupiter.api.Test;
import poker.Card;
import poker.Rank;
import poker.Suit;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FullHouseEvaluateTest {
    @Test
    public void eval() {
        List<Card> hands = new ArrayList<>();
        hands.add(new Card(Rank.DEUCE, Suit.SPADES));
        hands.add(new Card(Rank.DEUCE, Suit.CLUBS));

        List<Card> board = new ArrayList<>();
        board.add(new Card(Rank.DEUCE, Suit.HEARTS));
        board.add(new Card(Rank.THREE, Suit.CLUBS));
        board.add(new Card(Rank.THREE, Suit.SPADES));

        assertTrue(new FullHouseEvaluate().evaluate(hands, board));
    }

    @Test
    public void eval2() {
        List<Card> hands = List.of(new Card[]{ //
                new Card(Rank.DEUCE, Suit.SPADES),
                new Card(Rank.FOUR, Suit.CLUBS),
        });

        List<Card> board = List.of(new Card[]{ //
                new Card(Rank.DEUCE, Suit.HEARTS),
                new Card(Rank.THREE, Suit.CLUBS),
                new Card(Rank.THREE, Suit.SPADES),
        });

        assertFalse(new FullHouseEvaluate().evaluate(hands, board));
    }
}