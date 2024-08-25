package poker;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Dealer {
    private final Deck deck = new Deck();
    private final List<Player> players = new ArrayList<>();
    private final List<Card> flop = new ArrayList<>();

    public Dealer() {
        int totalPlayer = ThreadLocalRandom.current().nextInt(2, 9);
        generatePlayers(totalPlayer);
        distributeCards(totalPlayer);
        playGame();
    }

    private void playGame() {
        for (Phase phase : Phase.values()) {
            System.out.println("Phase: " + phase);
            System.out.println("=================================================================");
            drawCards(phase);
            showPlayers();
        }
    }

    private void showPlayers() {

        for (Player player : this.players) {
            List<Card> hand = player.getHand();
            System.out.println("player name:  " + player.getName());
            System.out.println("player hand:  " + player.getHand().stream().sorted(Comparator.comparing(Card::getRank)).toList());
            System.out.println("Eval:         " + CardValidation.validate(hand, flop));
            System.out.println("-----------------------------------------------------------------");
        }
    }

    private void drawCards(Phase phase) {
        for (int x = 0; x < phase.getQty(); x++) {
            this.flop.add(this.deck.getOneCard());
        }
        System.out.println("flop:    " + //
                this.flop.stream().sorted(Comparator.comparing(Card::getRank)).toList() //
        );
        System.out.println("#################################################################");
    }

    private void distributeCards(int totalPlayer) {
        for (int x = 0; x < totalPlayer; x++) {
            Player player = players.get(x);
            player.getHand().add(deck.getOneCard());
        }
    }

    private void generatePlayers(int totalPlayer) {
        System.out.println("Qtd. jogadores: " + totalPlayer);
        for (int x = 0; x < totalPlayer; x++) {
            Player player = new Player("Player " + (x + 1), new BigInteger("10000"));
            player.getHand().add(deck.getOneCard());
            players.add(player);
        }
    }
}
