package engine.controllers;

import io.QuestionCatalogIO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import models.Question;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static engine.controllers.ExceptionHandling.warningDisplay;
import static engine.controllers.ScreenController.loadSceneToSecondaryStage;

public class BonusLevelController implements Initializable{

    @FXML
    public javafx.scene.control.TextField questionField;
    @FXML
    public javafx.scene.control.TextField  answerField1;
    @FXML
    public javafx.scene.control.TextField  answerField2;
    @FXML
    public javafx.scene.control.TextField  answerField3;
    @FXML
    public javafx.scene.control.TextField  answerField4;
    @FXML
    public javafx.scene.control.TextField  correctAnswerField;
    @FXML
    public Button newQuestion;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void addNewQuestion(ActionEvent actionEvent) {
        boolean isNotEmpty = !questionField.getText().isEmpty() && !answerField1.getText().isEmpty()
                && !answerField2.getText().isEmpty() && !answerField3.getText().isEmpty()
                && !answerField4.getText().isEmpty() && !correctAnswerField.getText().isEmpty();

        if (isNotEmpty){
            Question newQuestion = new Question(questionField.getText(),answerField1.getText(),answerField2.getText(),
                    answerField3.getText(),answerField4.getText(),correctAnswerField.getText());
            QuestionCatalogIO.writeQuiz(newQuestion);
            try {
                loadSceneToSecondaryStage("GameChoose");
            } catch (IOException e) {
            }
        }else {

            warningDisplay("Cannot have a empty fields");
        }
    }
}
