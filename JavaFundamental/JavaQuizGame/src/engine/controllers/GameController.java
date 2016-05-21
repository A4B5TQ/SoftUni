package engine.controllers;

import io.PlayerCatalogIO;
import io.QuestionCatalogIO;
import io.RankListIO;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;
import models.Player;
import models.Question;
import models.QuestionsCatalog;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import static engine.controllers.ExceptionHandling.*;
import static engine.controllers.ScreenController.*;

public class GameController implements Initializable {
    private boolean isAnswerChosen;
    private Question que;
    private QuestionsCatalog catalog;
    private boolean isNextQuestion = true;
    private Player player = LogInController.player;
    private TreeMap<String, Integer> LOP = new TreeMap<>();
    private static Integer MAX_GAME_SCORE = 50;

    @FXML
    public Button startButton;
    @FXML
    public Button answerAButton;
    @FXML
    public Button answerBButton;
    @FXML
    public Button answerCButton;
    @FXML
    public Button answerDButton;

    @FXML
    public Label question;

    @FXML
    public Label scoresLabel;

    public List<Button> answerButtons;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        isAnswerChosen = false;
        answerButtons = new ArrayList<>();
        answerButtons.add(answerAButton);
        answerButtons.add(answerBButton);
        answerButtons.add(answerCButton);
        answerButtons.add(answerDButton);

    }

    @FXML
    public void chooseAnswerHandler(ActionEvent event) throws IOException {
        if (GameChooseController.gameType.equals("single")) {

            if (isNextQuestion && !isAnswerChosen) {
                String buttonStl = answerAButton.getStyle();
                String buttonAnswerText = ((Button) event.getSource()).getText();
                boolean isRight = que.checkCorrectAnswer(buttonAnswerText);
                isAnswerChosen = true;

                for (Button answerButton : answerButtons) {
                    String answers = answerButton.getText();
                    if (que.checkCorrectAnswer(answers)) {
                        answerButton.setStyle("-fx-background-color:#7fff00");
                    }
                }
                if (!isRight) {
                    ((Button) event.getSource()).setStyle("-fx-background-color:#dc143c");

                } else {
                    player.setPlayerScore(player.getPlayerScore() + 10);
                    LOP.put(player.getName(), player.getPlayerScore());
                }

                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(2000), e -> {
                    for (Button answerButton : answerButtons) {
                        answerButton.setStyle(buttonStl);
                    }
                    isAnswerChosen = false;
                    if (!isNextQuestion) {
                        disableAnswerButtons(true);
                    }
                    try {
                        catalog.nextQuestion();
                        que.nextQuestion(catalog);
                        setNewQuestion(que);
                    } catch (Exception ex) {
                        isNextQuestion = false;
                        PlayerCatalogIO.savePlayer(player);
                        if (!isNextQuestion) {
                            try {
                                loadSceneToSecondaryStage("GameChoose");
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }));
                timeline.play();
            }
        } else if (GameChooseController.gameType.equals("challenge")) {
            scoresLabel.setText("Scores To BonusLevel: " + Math.abs(MAX_GAME_SCORE - player.getPlayerScore()));
            if (isNextQuestion && !isAnswerChosen) {
                String buttonStl = answerAButton.getStyle();
                String buttonAnswerText = ((Button) event.getSource()).getText();
                boolean isRight = que.checkCorrectAnswer(buttonAnswerText);
                isAnswerChosen = true;

                for (Button answerButton : answerButtons) {
                    String answers = answerButton.getText();
                    if (que.checkCorrectAnswer(answers)) {
                        answerButton.setStyle("-fx-background-color:#7fff00");
                    }
                }
                if (!isRight) {
                    ((Button) event.getSource()).setStyle("-fx-background-color:#dc143c");

                } else {
                    Integer currentPlayerScore = player.getPlayerScore();
                    player.setPlayerScore(currentPlayerScore + 10);
                    LOP.put(player.getName(), player.getPlayerScore());
                }

                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(2000), e -> {
                    for (Button answerButton : answerButtons) {
                        answerButton.setStyle(buttonStl);
                    }
                    isAnswerChosen = false;
                    if (!isNextQuestion) {
                        disableAnswerButtons(true);
                    }
                    try {
                        catalog.nextQuestion();
                        que.nextQuestion(catalog);
                        setNewQuestion(que);
                    } catch (Exception ex) {
                        isNextQuestion = false;
                        LOP.put(player.getName(), player.getPlayerScore());
                        RankListIO.WriteRankList(LOP);
                    }
                }));
                timeline.play();
            }
            if (Integer.compare(player.getPlayerScore(), MAX_GAME_SCORE) == 0 && !isNextQuestion) {
                displayConfirm("CONGRATULATIONS", "Do you want to write a new Question?");
                if (isConfirm()) {
                    loadSceneToBonusStage("BonusLevel");
                    MAX_GAME_SCORE +=10;
                } else if (isCancel()) {
                    loadSceneToSecondaryStage("GameChoose");
                }
            } else if (Integer.compare(player.getPlayerScore(), MAX_GAME_SCORE) == -1 && !isNextQuestion) {
                try {
                    displayConfirm("SORRY", "Do you want to continue");
                    if (isConfirm()) {
                        loadSceneToSecondaryStage("GameChoose");
                    } else if (isCancel()) {
                        closeStage(thirdStage);
                    }
                } catch (IOException e1) {
                }
            }
        }
    }

    private void disableAnswerButtons(boolean value) {
        for (Button answerButton : answerButtons) {
            answerButton.setDisable(value);
            answerButton.setVisible(value);
        }
    }

    public void startGame(ActionEvent actionEvent) throws InterruptedException, IOException {
        startButton.setVisible(false);
        QuestionCatalogIO IO = new QuestionCatalogIO();
        catalog = new QuestionsCatalog(IO);
        que = new Question(catalog);
        catalog.nextQuestion();
        setNewQuestion(que);
    }

    private void setNewQuestion(Question que) {
        if (GameChooseController.gameType.equals("challenge")) {
            scoresLabel.setVisible(true);
            scoresLabel.setText("Scores To BonusLevel: " + Math.abs(MAX_GAME_SCORE - player.getPlayerScore()));
        }
        question.setText(que.getQUESTION());
        question.setWrapText(true);
        Collections.shuffle(answerButtons);
        answerButtons.get(0).setText(que.getANSWERS().get(0));
        answerButtons.get(0).setWrapText(true);
        answerButtons.get(1).setText(que.getANSWERS().get(1));
        answerButtons.get(1).setWrapText(true);
        answerButtons.get(2).setText(que.getANSWERS().get(2));
        answerButtons.get(2).setWrapText(true);
        answerButtons.get(3).setText(que.getANSWERS().get(3));
        answerButtons.get(3).setWrapText(true);
    }
}
