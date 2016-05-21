package models;

public class Player {

    private String Name;
    private String Password;

    public Integer getPlayerScore() {
        return PlayerScore;
    }

    public void setPlayerScore(Integer playerScore) {
        PlayerScore = playerScore;
    }

    private int PlayerScore;

    public Player(String name, String password) {
        this.setName(name);
        this.setPassword(password);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {

        if (name.isEmpty()) {
            //warningDisplay("Name must be more than 0 symbols");
            throw new IllegalArgumentException("Name must be more than 0 symbols");
        }

        this.Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) throws IllegalArgumentException {

        if (password.isEmpty()) {
            //warningDisplay("Password must be more than 0 symbols");
            throw new IllegalArgumentException("Password must be more than 0 symbols");
        }

        this.Password = password;
    }
}
