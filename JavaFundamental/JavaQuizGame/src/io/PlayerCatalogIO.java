package io;


import models.Player;

import java.io.*;
import java.util.TreeMap;

import static engine.controllers.ExceptionHandling.warningDisplay;

public class PlayerCatalogIO {

    public static void addPlayer(Player player) {
        String name = player.getName();
        String password = player.getPassword();
        String score = "0";
        String newPlayer = (name + "|" + password + "|" + score);

        try {
            BufferedWriter playerWriter = new BufferedWriter(new FileWriter("res/Players/PlayersCatalog.txt", true));
            playerWriter.write(newPlayer + "\r\n");
            playerWriter.close();

        } catch (IOException ioe) {
            warningDisplay("Cannot add player! Please restart");
        }
    }

    public static TreeMap<String, String> PlayerLoads() {
        String[] playerCatalog;
        TreeMap<String, String> player = new TreeMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("res/Players/PlayersCatalog.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                playerCatalog = line.split("\\|");
                if (playerCatalog.length > 1){

                    player.put(playerCatalog[0],playerCatalog[1]);
                }
            }
        } catch (FileNotFoundException e) {
            warningDisplay("Cannot load player data! File not found");
        } catch (IOException e) {
            warningDisplay("Cannot load list of players! Please restart");
        }
        return player;
    }

    public static TreeMap<String, String> LoadPlayers() {
        TreeMap<String,String> player = PlayerLoads();
        return player;
    }
    public static TreeMap<String,Integer> loadPlayerScores(){
        String[] playerData;
        TreeMap<String, Integer> player = new TreeMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("res/Players/PlayersCatalog.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                playerData = line.split("\\|");
                if (playerData.length > 1){
                    player.put(playerData[0], Integer.parseInt(playerData[2]));
                }
            }
        } catch (FileNotFoundException e) {
            warningDisplay("Cannot load player data! File not found");
        } catch (IOException e) {
            warningDisplay("Cannot load list of player scores! Please restart");
        }
        return player;
    }
    public static void savePlayer(Player player) {
        String name = player.getName();
        String password = player.getPassword();
        int score = player.getPlayerScore();
        String newPlayer = (name + "|" + password + "|" + score);

        try {
            BufferedWriter playerWriter = new BufferedWriter(new FileWriter("res/Players/PlayersCatalog.txt",true));
            playerWriter.write(newPlayer + "\r\n");
            playerWriter.close();

        } catch (IOException ioe) {
            warningDisplay("Cannot save player data! Please restart");
        }
    }
}



