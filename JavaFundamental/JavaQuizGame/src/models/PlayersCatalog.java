package models;

import io.PlayerCatalogIO;

import java.util.Objects;
import java.util.TreeMap;

import static engine.controllers.ExceptionHandling.warningDisplay;

public class PlayersCatalog {

    private TreeMap<String, String> playersCatalog = new TreeMap<>();

    public PlayersCatalog() {
        this.playersCatalog = PlayerCatalogIO.LoadPlayers();
    }

    public Player addNewPlayer(String name, String password) {
        Player player;
        if (password.isEmpty()){
            warningDisplay("Please enter a password");
        }
        if (playersCatalog.containsKey(name)) {
            warningDisplay("The Player name already exist!");
            throw new IllegalArgumentException("Player name must be unique");
        } else {
            player = new Player(name, password);
            PlayerCatalogIO.addPlayer(player);
        }
        return player;
    }

    public Player getExistingPlayer(String name, String password) {

        if (name.isEmpty()) {
            warningDisplay("Please enter player name");
        } else if (password.isEmpty()) {
            warningDisplay("Please enter the password");
        } else if (!playersCatalog.containsKey(name)) {
            warningDisplay("Player do not exist");
            throw new IllegalArgumentException("Player do not exist");
        } else if (!Objects.equals(playersCatalog.get(name), password)) {
            warningDisplay("Password is not correct");
            throw new IllegalArgumentException("Password is not correct");
        }

        Player player = new Player(name, password);
        return player;
    }

    public int getPlayerScores(String playerName) {
        TreeMap<String, Integer> playerScore = PlayerCatalogIO.loadPlayerScores();
        int playerScores = playerScore.get(playerName);
        return playerScores;
    }
}


