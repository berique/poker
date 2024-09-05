package poker.evaluate;

import org.junit.jupiter.api.Test;
import poker.Card;
import poker.Rank;
import poker.Suit;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HighCardEvaluateTest {
    @Test
    void eval() {
        List<Card> hands = List.of(new Card[]{ //
                new Card(Rank.DEUCE, Suit.SPADES), //
                new Card(Rank.FOUR, Suit.CLUBS), //
        });

        List<Card> board = List.of(new Card[]{ //
                new Card(Rank.DEUCE, Suit.HEARTS),
                new Card(Rank.THREE, Suit.CLUBS),
                new Card(Rank.THREE, Suit.SPADES),
        });

        assertTrue(new HighCardEvaluate().evaluate(hands, board));
    }

}