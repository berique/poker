package poker;

import poker.evaluate.CardEvaluation;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Dealer {
    private final Deck deck = new Deck();
    private final List<Player> players = new ArrayList<>();
    private final List<Card> community = new ArrayList<>();
    private final PrintStream out = System.out;

    public Dealer(final PokerType pokerType) {
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
            if (phase == Phase.RIVER) {
                HashMap<Integer, List<Player>> hash = new HashMap<>();
                for (Player player : this.players) {
                    List<Card> hand = player.getHand();
                    CardEvaluation evaluation = CardValidation.validate(hand, community);
                    hash.computeIfAbsent(evaluation.ordinal(), (k) -> new ArrayList<>());
                    hash.get(evaluation.ordinal()).add(player);
                }
                int min = Collections.min(hash.keySet());
                List<Player> winners = hash.get(min);
                System.out.println("Winner" + (winners.size() == 1 ? "" : "s") + ":");
                System.out.println(repeat("#"));
                for (Player player : winners) {
                    System.out.println(player.getName());
                }
            }
        }
    }

    private String padding(final String s, final Object phase) {
        return s + " ".repeat(Math.max(16 - s.length(), 0)) + phase.toString();
    }

    private String repeat(final String ch) {
        return ch.repeat(65);
    }

    private void showPlayers() {
        for (Player player : this.players) {
            List<Card> hand = player.getHand();
            CardEvaluation evaluation = CardValidation.validate(hand, community);
            out.println(padding("Player name:", player.getName()));
            out.println(padding("Player hand:", player.getHand()));
            out.println(padding("Eval:", evaluation));
            out.println(repeat("-"));
        }
    }

    private List<Card> sortByRank(final List<Card> cards) {
        return cards.stream().sorted(Comparator.comparing(Card::getRank)).toList();
    }

    private void drawCards(final Phase phase) {
        this.community.addAll(this.deck.takeCards(phase.getTotalCards()));
        out.println(padding( //
                "Community:", //
                this.community //
        ));
    }

    private void distributeCards(final int totalCards, final int totalPlayer) {
        for (int y = 0; y < totalCards; y++) {
            for (int x = 0; x < totalPlayer; x++) {
                players.get(x).getHand().add(deck.takeOneCard());
            }
        }
    }

    private void generatePlayers(final int totalPlayer) {
        out.println(padding("Qtd. jogadores:", totalPlayer));
        for (int x = 0; x < totalPlayer; x++) {
            Player player = new Player("Player " + (x + 1), new BigInteger("1500"));
            players.add(player);
        }
    }
}
