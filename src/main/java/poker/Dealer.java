package poker;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Dealer {
    private final Deck deck = new Deck();
    private final List<Player> players = new ArrayList<>();
    private final List<Card> flop = new ArrayList<>();
    private final PrintStream out = System.out;

    public Dealer(PokerType pokerType) {
        int totalPlayer = ThreadLocalRandom.current().nextInt(2, pokerType.getTotalPlayers());
        generatePlayers(totalPlayer);
        distributeCards(pokerType.getTotalCards(), totalPlayer);
        playGame();
    }

    private void playGame() {
        for (Phase phase : Phase.values()) {
            out.println(padding("Phase:", phase));
            drawCards(phase);
            out.println(repeat("="));
            showPlayers();
        }
    }

    private String padding(String s, Object phase) {
        return s + " ".repeat(Math.max(15 - s.length(), 0)) + phase;
    }

    private String repeat(String ch) {
        return ch.repeat(65);
    }

    private void showPlayers() {
        for (Player player : this.players) {
            List<Card> hand = player.getHand();
            out.println(padding("Player name:", player.getName()));
            out.println(padding("Player hand:", byRank(player.getHand())));
            out.println(padding("Eval:", CardValidation.validate(hand, flop)));
            out.println(repeat("-"));
        }
    }

    private List<Card> byRank(List<Card> cards) {
        return cards.stream().sorted(Comparator.comparing(Card::getRank)).toList();
    }

    private void drawCards(Phase phase) {
        this.flop.addAll(this.deck.takeCards(phase.getTotalCards()));
        out.println(repeat("#"));
        out.println(padding( //
                "Flop:", //
                this.flop //
        ));
    }

    private void distributeCards(int totalCards, int totalPlayer) {
        for (int y = 0; y < totalCards; y++) {
            for (int x = 0; x < totalPlayer; x++) {
                players.get(x).getHand().add(deck.takeOneCard());
            }
        }
    }

    private void generatePlayers(int totalPlayer) {
        out.println(padding("Qtd. jogadores:", totalPlayer));
        for (int x = 0; x < totalPlayer; x++) {
            Player player = new Player("Player " + (x + 1), new BigInteger("10000"));
            players.add(player);
        }
    }
}
