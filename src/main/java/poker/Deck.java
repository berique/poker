package poker;

import java.util.*;

public class Deck {
    final List<Card> cards;

    private final int SEED = 929198;

    public Deck() {
        this.cards = createCardAndShuffle();
    }

    private List<Card> createCardAndShuffle() {
        List<Card> cards = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                cards.add(new Card(rank, suit));
            }
        }
        Collections.shuffle(cards, new Random(SEED));
        return cards;
    }

    public Card giveOneCard() {
        return cards.removeFirst();
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }
}
