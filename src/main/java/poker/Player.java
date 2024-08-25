package poker;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final List<Card> hand;
    private final BigInteger points;
    private final PlayerBehavior playerBehavior;

    public Player(String name, BigInteger points) {
        this.hand = new ArrayList<>();
        this.points = points;
        this.name = name;
        this.playerBehavior = null;
    }

    public Player(String name, BigInteger points, PlayerBehavior playerBehavior) {
        this.hand = new ArrayList<>();
        this.points = points;
        this.name = name;
        this.playerBehavior = playerBehavior;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public BigInteger getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Player{" + //
                "name='" + name + "'" + //
                ", hand=" + hand + //
                ", points=" + points + //
                "}";
    }
}
