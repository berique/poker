package poker;

import org.junit.jupiter.api.Test;
import poker.evaluate.CardEvaluation;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardValidationTest {

    @Test
    void validateFlush  () {

        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Rank.ACE, Suit.CLUBS));
        hand.add(new Card(Rank.KING, Suit.CLUBS));
        List<Card> flop = new ArrayList<>();
        flop.add(new Card(Rank.THREE, Suit.CLUBS));
        flop.add(new Card(Rank.FOUR, Suit.CLUBS));
        flop.add(new Card(Rank.FIVE, Suit.CLUBS));
        assertSame(CardValidation.validate(hand, flop), CardEvaluation.FLUSH);
    }

    @Test
    void validateRoyalFlush() {

        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Rank.ACE, Suit.CLUBS));
        hand.add(new Card(Rank.KING, Suit.CLUBS));
        List<Card> flop = new ArrayList<>();
        flop.add(new Card(Rank.QUEEN, Suit.CLUBS));
        flop.add(new Card(Rank.JACK, Suit.CLUBS));
        flop.add(new Card(Rank.TEN, Suit.CLUBS));
        assertSame(CardValidation.validate(hand, flop), CardEvaluation.ROYAL_FLUSH);
    }

    @Test
    void validateHighCard() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Rank.ACE, Suit.CLUBS));
        hand.add(new Card(Rank.KING, Suit.DIAMONDS));
        List<Card> flop = new ArrayList<>();
        flop.add(new Card(Rank.THREE, Suit.SPADES));
        flop.add(new Card(Rank.FOUR, Suit.CLUBS));
        flop.add(new Card(Rank.FIVE, Suit.CLUBS));
        assertSame(CardValidation.validate(hand, flop), CardEvaluation.HIGH_CARD);
    }

    @Test
    void validateTwoPair() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Rank.ACE, Suit.CLUBS));
        hand.add(new Card(Rank.ACE, Suit.DIAMONDS));
        List<Card> flop = new ArrayList<>();
        flop.add(new Card(Rank.THREE, Suit.SPADES));
        flop.add(new Card(Rank.FOUR, Suit.CLUBS));
        flop.add(new Card(Rank.FOUR, Suit.HEARTS));
        assertSame(CardValidation.validate(hand, flop), CardEvaluation.TWO_PAIR);
    }
}