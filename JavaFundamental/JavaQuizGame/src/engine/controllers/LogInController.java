package engine.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.Player;
import models.UserLogger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static engine.controllers.ScreenController.loadSceneToSecondaryStage;

public class LogInController implements Initializable {
    public static Player player;

    @FXML
    public Button logInButton;
    @FXML
    public Button signUpButton;
    @FXML
    private TextField userNameField;
    @FXML
    private TextField userPasswordField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void logIn(ActionEvent actionEvent) {
        UserLogger logger = new UserLogger();
        player = logger.logIn(userNameField.getText(),userPasswordField.getText());
        player.setPlayerScore(logger.PlayerScore(player.getName()));
        try {
            loadSceneToSecondaryStage("GameChoose");
        } catch (IOException e) {
            System.out.println("Exception from loadSceneToSecondary");
        }
    }

    public void signUp(ActionEvent actionEvent) {
        UserLogger logger = new UserLogger();
        player = logger.signUp(userNameField.getText(),userPasswordField.getText());
        try {
            loadSceneToSecondaryStage("GameChoose");
        } catch (IOException e) {
            System.out.println("Exception from loadSceneToSecondary");
        }
    }
}
