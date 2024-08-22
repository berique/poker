package poker.evaluate;

import poker.Card;
import poker.Rank;
import poker.Suit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TwoPairEvaluateTest {
    @Test
    void evaluate() {
        List<Card> hands = new ArrayList<>();
        hands.add(new Card(Rank.TEN, Suit.DIAMONDS));
        hands.add(new Card(Rank.TEN, Suit.HEARTS));

        List<Card> flop = new ArrayList<>();
        flop.add(new Card(Rank.SEVEN, Suit.SPADES));
        flop.add(new Card(Rank.SEVEN, Suit.CLUBS));
        flop.add(new Card(Rank.KING, Suit.CLUBS));

        assertTrue(new TwoPairEvaluate().evaluate(hands, flop));
    }

    @Test
    void evaluate2() {
        List<Card> hands = new ArrayList<>();
        hands.add(new Card(Rank.TEN, Suit.DIAMONDS));
        hands.add(new Card(Rank.TEN, Suit.HEARTS));

        List<Card> flop = new ArrayList<>();
        flop.add(new Card(Rank.SEVEN, Suit.SPADES));
        flop.add(new Card(Rank.KING, Suit.CLUBS));
        flop.add(new Card(Rank.SEVEN, Suit.CLUBS));

        assertTrue(new TwoPairEvaluate().evaluate(hands, flop));
    }

    @Test
    void evaluate3() {
        List<Card> hands = new ArrayList<>();
        hands.add(new Card(Rank.TEN, Suit.DIAMONDS));
        hands.add(new Card(Rank.SEVEN, Suit.SPADES));

        List<Card> flop = new ArrayList<>();
        flop.add(new Card(Rank.TEN, Suit.HEARTS));
        flop.add(new Card(Rank.KING, Suit.CLUBS));
        flop.add(new Card(Rank.SEVEN, Suit.CLUBS));

        assertTrue(new TwoPairEvaluate().evaluate(hands, flop));
    }

    @Test
    void evaluate4() {
        List<Card> hands = new ArrayList<>();
        hands.add(new Card(Rank.TEN, Suit.DIAMONDS));
        hands.add(new Card(Rank.SEVEN, Suit.SPADES));

        List<Card> flop = new ArrayList<>();
        flop.add(new Card(Rank.QUEEN, Suit.HEARTS));
        flop.add(new Card(Rank.KING, Suit.CLUBS));
        flop.add(new Card(Rank.SEVEN, Suit.CLUBS));

        assertFalse(new TwoPairEvaluate().evaluate(hands, flop));
    }
}