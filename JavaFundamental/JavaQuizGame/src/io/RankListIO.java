package io;

import java.io.*;
import java.util.TreeMap;

import static engine.controllers.ExceptionHandling.warningDisplay;

public class RankListIO {

    public static TreeMap<String, Integer> LoadRankList() {
        TreeMap<String, Integer> list = new TreeMap<>();
        try (ObjectInputStream objReader = new ObjectInputStream(new FileInputStream("res/Players/RankList.list"))){
            list = (TreeMap<String, Integer>) objReader.readObject();
        } catch (FileNotFoundException e) {
            warningDisplay("RankList file not found");
        } catch (IOException e) {
            warningDisplay("Cannot load RankList data! Please check for missing .list files");
        } catch (ClassNotFoundException e) {
            warningDisplay("RankList file not found! ClassNotFoundException");
        }
        return list;
    }

    public static void WriteRankList(TreeMap<String, Integer> listOfPlayers) {
        TreeMap<String, Integer> LOP = listOfPlayers;
        try (ObjectOutputStream objWriter = new ObjectOutputStream(new FileOutputStream("res/Players/RankList.list"))) {
            objWriter.writeObject(LOP);
            objWriter.flush();
        } catch (FileNotFoundException e) {
            warningDisplay("RankList file not found! Cannot write the data");
        } catch (IOException e) {
            warningDisplay("Cannot save RankList data! Please check for missing .list files");
        }
    }
}



