package poker.evaluate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import poker.Card;
import poker.Rank;
import poker.Suit;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StraightEvaluateTest {

    @DisplayName("Straight Ten to six")
    @Test
    void evaluate() {
        List<Card> hands = new ArrayList<>();
        hands.add(new Card(Rank.TEN, Suit.DIAMONDS));
        hands.add(new Card(Rank.NINE, Suit.HEARTS));

        List<Card> board = new ArrayList<>();
        board.add(new Card(Rank.EIGHT, Suit.SPADES));
        board.add(new Card(Rank.SEVEN, Suit.CLUBS));
        board.add(new Card(Rank.SIX, Suit.CLUBS));

        assertEquals( //
                new StraightEvaluate().evaluate(hands, board), //
                true //
        );
    }

    @DisplayName("Not Straight")
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

    @DisplayName("Straight with low ace")
    @Test
    void evaluate2() {
        List<Card> hands = List.of(new Card[]{ //
                new Card(Rank.FIVE, Suit.DIAMONDS),
                new Card(Rank.FOUR, Suit.HEARTS),
        });

        List<Card> board = List.of(new Card[]{ //
                new Card(Rank.THREE, Suit.SPADES), //
                new Card(Rank.DEUCE, Suit.CLUBS), //
                new Card(Rank.ACE, Suit.CLUBS), //
        });

        assertTrue(new StraightEvaluate().evaluate(hands, board));
    }
}