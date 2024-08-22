package poker;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> currentPlayers = new ArrayList<>();

    public void addPlayer(Player player) {
        this.currentPlayers.add(player);
    }

}
