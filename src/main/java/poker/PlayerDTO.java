package poker;

import java.math.BigInteger;

public class PlayerDTO {
    private final String name;
    private final BigInteger points;
    private final boolean button;

    public PlayerDTO(String name, BigInteger points, boolean button) {
        this.name = name;
        this.points = points;
        this.button = button;
    }

    public boolean hasButton() {
        return button;
    }

    public String getName() {
        return name;
    }

    public BigInteger getPoints() {
        return points;
    }
}
