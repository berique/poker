package poker.evaluate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import poker.Card;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RoyalFlushEvaluateTest {

    @DisplayName("Eval Royal Flush")
    @Test
    public void eval() {
        List<Card> hand = List.of(new Card[]{ //
                new Card("K♣️"), //
                new Card("A♣️"), //
        });
        List<Card> flop = List.of(new Card[]{ //
                new Card("10♣️"), //
                new Card("Q♣️"), //
                new Card("J♣️"), //
        });
        assertTrue(new RoyalFlushEvaluate().evaluate(hand, flop));
    }
}