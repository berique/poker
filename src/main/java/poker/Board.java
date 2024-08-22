package poker;

import java.util.LinkedList;
import java.util.List;

public class Board {
    private final Deck deck;
    private final List<Player> players = new LinkedList<>();

    public Board() {
        this.deck = new Deck();
    }

}
