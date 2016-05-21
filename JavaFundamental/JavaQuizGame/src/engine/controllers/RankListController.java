package engine.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import models.RankList;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.SortedMap;

import static engine.controllers.ScreenController.loadSceneToRankListStage;
import static engine.controllers.ScreenController.rankListStage;

public class RankListController implements Initializable {

    private static RankList list = new RankList();
    @FXML
    public static VBox userNames = new VBox(list.displayList().size());
    @FXML
    public static VBox scores = new VBox(list.displayList().size());
    @FXML
    public static Button closeButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public static void display(){
        try {
            loadSceneToRankListStage("RankList");
        } catch (IOException e) {
        }
        SortedMap<String,Integer> data = list.displayList();
        userNames.setLayoutX(359);
        userNames.setLayoutY(271);
        scores.setLayoutX(565);
        scores.setLayoutY(271);
        userNames.setPrefHeight(200);
        userNames.setPrefWidth(100);
        scores.setPrefHeight(200);
        scores.setPrefWidth(100);
        for (Map.Entry entry : data.entrySet()) {
            Label user = new Label(entry.getKey().toString());
            user.setTextFill(Color.WHITE);
            user.setFont(new Font("Arial",20));
            Label score = new Label(entry.getValue().toString());
            score.setTextFill(Color.WHITE);
            score.setFont(new Font("Arial",20));
            userNames.getChildren().addAll(user);
            scores.getChildren().addAll(score);
            userNames.setAlignment(Pos.TOP_CENTER);
            scores.setAlignment(Pos.TOP_CENTER);
            ScreenController.rankListScene.getChildren().addAll(userNames,scores);
        }
    }

    public void isClosePressed(ActionEvent actionEvent) {
        ScreenController.closeStage(rankListStage);
    }
}
