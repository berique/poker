package poker;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;
    private BigInteger points;

    private Player() {
        this.hand = new ArrayList<>();
    }

    public Player(String name, BigInteger points) {
        this();
        this.points = points;
        this.name = name;
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
        return "Player{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                ", points=" + points +
                '}';
    }
}
