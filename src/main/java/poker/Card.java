package poker;

public class Card {
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.suit = suit;
        this.rank = rank;
    }

    public Card(String card) {
        String c = card.trim();
        Rank rank = null;
        Suit suit = null;

        String cardRankSubstring1 = c.substring(0, 1);
        String rank2 = c.substring(0, 2);
        String suit1 = c.substring(1);
        String suit2 = c.substring(2);
        for (Rank value : Rank.values()) {
            if (value.toString().equalsIgnoreCase(cardRankSubstring1) || value.toString().equalsIgnoreCase(rank2)) {
                rank = value;
                break;
            }
        }
        for (Suit value : Suit.values()) {
            if (value.toString().equalsIgnoreCase(suit1) || value.toString().equalsIgnoreCase(suit2)) {
                suit = value;
                break;
            }
        }
        if (rank == null || suit == null) {
            throw new RuntimeException("Unable to parse card: " + card );
        } else {
            this.rank = rank;
            this.suit = suit;
        }
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return String.valueOf(this.rank) + String.valueOf(suit);
    }
}
