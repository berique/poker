package poker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {
    @Test
    public void card() {
        Card card = new Card("7♣️");
        assertEquals(card.getRank(), Rank.SEVEN);
        assertEquals(card.getSuit(), Suit.CLUBS);
    }

    @Test
    public void card1() {
        Card card = new Card("A♣️");
        assertEquals(card.getRank(), Rank.ACE);
        assertEquals(card.getSuit(), Suit.CLUBS);
    }

    @Test
    public void card3() {
        Card card = new Card("10♣️");
        assertEquals(card.getRank(), Rank.TEN);
        assertEquals(card.getSuit(), Suit.CLUBS);
    }
}