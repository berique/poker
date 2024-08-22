package poker.evaluate;

import org.junit.jupiter.api.Test;
import poker.Card;

import java.util.ArrayList;
import java.util.List;

class RoyalFlushEvaluateTest {

    @Test
    public void eval() {
        List<Card> hand = List.of(new Card[]{new Card("9♣️"), new Card("J♥️")});
        List<Card> flop = List.of(new Card[]{new Card("8♣️"), new Card("7♣️"), new Card("J♠️"), new Card("10♣️"), new Card("K♣️")});
        new RoyalFlushEvaluate().evaluate(hand, flop);
    }
}