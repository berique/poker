package poker;

import java.math.BigInteger;
import java.time.Duration;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Dealer {
    private Board board;
    private Deck deck;
    private List<Player> players;
    private List<Card> flop = new ArrayList<>();

    public Dealer() {
        this.board = new Board();
        this.deck = new Deck();
        this.players = new ArrayList<>();
        CardValidation cardValidation = new CardValidation();
        int totalPlayer = ThreadLocalRandom.current().nextInt(2, 14);
        System.out.println("Qtd. jogadores: " + totalPlayer);
        for (int x = 0; x < totalPlayer; x++) {
            Player player = new Player("" + (x + 1), new BigInteger("10000"));
            player.getHand().add(deck.giveOneCard());
            players.add(player);
        }
        for (int x = 0; x < totalPlayer; x++) {
            Player player = players.get(x);
            player.getHand().add(deck.giveOneCard());
        }
        for (Phase phase : Phase.values()) {
            System.out.println(phase);
            System.out.println("=================================================================");
            for (int x = 0; x < phase.getQty(); x++) {
                flop.add(deck.giveOneCard());
            }
            for (Player player : players) {
                List<Card> hand = player.getHand();
                System.out.println("player:  " + player);
                System.out.println("flop:    " + flop.toString());
                System.out.println("Eval:    " + CardValidation.validate(hand, flop));
                System.out.println("-----------------------------------------------------------------");
            }
        }
    }
}
