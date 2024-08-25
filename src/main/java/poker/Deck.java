package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private static final int SEED = 929198;
    private final List<Card> cards;

    public Deck() {
        List<Card> cards = createDeck();
        this.cards = shuffleCards(cards);
    }

    private List<Card> createDeck() {
        List<Card> cards = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                cards.add(new Card(rank, suit));
            }
        }
        return cards;
    }

    private List<Card> shuffleCards(List<Card> cards) {
        Collections.shuffle(cards, new Random(SEED));
        return cards;
    }

    public Card getOneCard() {
        return getCards(1).getFirst();
    }

    public List<Card> getCards(int qty) {
        List<Card> cards = new ArrayList<>();
        for (int x = 0; x < qty; x++) {
            cards.add(this.cards.removeFirst());
        }
        return cards;
    }

    @Override
    public String toString() {
        return "Deck{" + //
                "cards=" + cards + //
                "}";
    }
}
