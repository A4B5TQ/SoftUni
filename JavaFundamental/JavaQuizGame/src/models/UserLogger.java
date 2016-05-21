package models;

public class UserLogger {

    private static PlayersCatalog playersCatalog;

    public UserLogger() {
        playersCatalog = new PlayersCatalog();
    }

    public static Player signUp(String name, String password) {
        return getPlayersCatalog().addNewPlayer(name, password);
    }

    public static Player logIn(String name, String password) {
        return playersCatalog.getExistingPlayer(name, password);
    }
    public static Integer PlayerScore(String name) {
        return playersCatalog.getPlayerScores(name);
    }

    public static PlayersCatalog getPlayersCatalog() {
        return playersCatalog;
    }
}
