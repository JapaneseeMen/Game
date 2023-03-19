import java.util.List;

public class Game {
    private List<Player> listPlayers;

    public Game(List<Player> listPlayers) {
        this.listPlayers = listPlayers;
    }

    public boolean register(Player player) {
        return listPlayers.contains(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (!register(player1)) {
            throw new NoRegisteredException(playerName1);
        }
        if (!register(player2)) {
            throw new NoRegisteredException(playerName2);
        }
        if (player1.equals(player2)) {
            throw new IncorrectDataException("Введите имя второго игрока");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }

    public Player findByName(String name) {
        if (name == null) {
            throw new IncorrectDataException("Введите имя игрока");
        }
        if (name.equals("")) {
            throw new IncorrectDataException("Введите имя игрока");
        }
        for (Player gamer : listPlayers) {
            if (gamer.getName().contains(name))
                return gamer;
        }
        return null;
    }
}
