package repositories;

import entities.Player;
import exceptions.PlayerAlreadyExistsException;
import exceptions.PlayerNotExistsException;
import util.ConsolePrint;
import util.Print;

import java.util.HashMap;
import java.util.Map;

public class PlayerRepo {
    private final Map<Integer, Player> players;
    private final Print print;

    public PlayerRepo() {
        players = new HashMap<>();
        print = ConsolePrint.getInstance();
    }

    public void addPlayer(Player player) {
        if(players.containsKey(player.getId())) {
            print.printMessage("Player id already exists!");
            throw new PlayerAlreadyExistsException();
        }
        players.put(player.getId(), player);
    }

    public Player getPlayer(int id) {
        if(!players.containsKey(id)) {
            print.printMessage("Player does not exists!");
            throw new PlayerNotExistsException();
        }
        return players.get(id);
    }

    public static PlayerRepo getInstance() {
        return PlayerRepo.SingletonInstance.INSTANCE;
    }

    static class SingletonInstance {
        private final static PlayerRepo INSTANCE = new PlayerRepo();
    }
}
