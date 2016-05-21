package engine.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import models.Player;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static engine.controllers.ScreenController.loadSceneToThirdStage;

public class GameChooseController implements Initializable {

    public static String quizChoose = "";
    public static String gameType = "";
    public Player player = LogInController.player;

    @FXML
    public Button javaBasicQuiz;
    @FXML
    public Button javaArrayQuiz;
    @FXML
    public Button javaCollectionQuiz;
    @FXML
    public Button javaOOPQuiz;
    @FXML
    public Button backButton;
    @FXML
    public Label backLabel;
    @FXML
    public VBox selectQuiz;
    @FXML
    public VBox gameModeButtons;
    @FXML
    public Button challengeGame;
    @FXML
    public Button singleGame;

    @FXML
    public Button rankList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void basicChoose(ActionEvent actionEvent) throws IOException {
        quizChoose = QUESTION_FILE_NAME.JAVA_BASIC_QUIZ.toString();
        selectQuiz.setVisible(false);
        gameModeButtons.setVisible(true);
        backLabel.setVisible(true);
        rankList.setVisible(true);
    }

    public void arrayChoose(ActionEvent actionEvent) throws IOException {
        quizChoose = QUESTION_FILE_NAME.JAVA_ARRAY_QUIZ.toString();
        selectQuiz.setVisible(false);
        gameModeButtons.setVisible(true);
        backLabel.setVisible(true);
        rankList.setVisible(true);
    }

    public void collectionChoose(ActionEvent actionEvent) throws IOException {
        quizChoose = QUESTION_FILE_NAME.COLLECTION_QUIZ.toString();
        selectQuiz.setVisible(false);
        gameModeButtons.setVisible(true);
        backLabel.setVisible(true);
        rankList.setVisible(true);
    }

    public void oopChoose(ActionEvent actionEvent) throws IOException {
        quizChoose = QUESTION_FILE_NAME.JAVA_OOP_QUIZ.toString();
        selectQuiz.setVisible(false);
        gameModeButtons.setVisible(true);
        backLabel.setVisible(true);
        rankList.setVisible(true);
    }

    public void pressedBack(ActionEvent actionEvent) {
        gameModeButtons.setVisible(false);
        selectQuiz.setVisible(true);
        backLabel.setVisible(false);
    }

    public void selectSingleGame(ActionEvent actionEvent) throws IOException {
        gameType = "single";
        loadSceneToThirdStage("QuizSolving");
    }

    public void selectChallengeGame(ActionEvent actionEvent) throws IOException {
        gameType = "challenge";
        Integer plScore = 0;
        player.setPlayerScore(plScore);
        loadSceneToThirdStage("QuizSolving");
    }

    enum QUESTION_FILE_NAME{
        JAVA_BASIC_QUIZ,
        JAVA_ARRAY_QUIZ,
        JAVA_OOP_QUIZ,
        COLLECTION_QUIZ
    }
    public static String getQuizChoose() {
        return quizChoose;
    }
    public void rankListPressed(ActionEvent event){
        RankListController.display();
    }
}
