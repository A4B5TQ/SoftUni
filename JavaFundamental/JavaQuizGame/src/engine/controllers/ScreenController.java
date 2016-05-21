package engine.controllers;

import engine.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ScreenController {
    public static Stage primaryStage;
    public static Stage secondaryStage;
    public static Stage thirdStage;
    public static Stage bonusStage;
    public static Stage rankListStage;
    public static AnchorPane root;
    public static Pane gameChooseScene;
    public static Pane quizScene;
    public static Pane bonusScene;
    public static Pane rankListScene;

    public static void setPrimaryStage(Stage primaryStage) throws IOException {
        primaryStage.setTitle(Main.TITLE);
        root = FXMLLoader.load(Main.class.getResource("scenes/LogIn.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        ScreenController.primaryStage = primaryStage;
    }

    public static <T> T loadSceneToPrimaryStage(String fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("scenes/" + fxml + ".fxml"));

        try {
            root = FXMLLoader.load(Main.class.getResource("scenes/LogIn.fxml"));
            primaryStage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }

        primaryStage.show();
        return fxmlLoader.<T>getController();
    }

    public static <T> T loadSceneToSecondaryStage(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("scenes/" + fxml + ".fxml"));

        if (secondaryStage == null) {
            secondaryStage = new Stage();
        }
        try {
            gameChooseScene = FXMLLoader.load(Main.class.getResource("scenes/GameChoose.fxml"));
            secondaryStage.setScene(new Scene(gameChooseScene));
            secondaryStage.setTitle(Main.TITLE);
            secondaryStage.setResizable(false);
            closeStage(primaryStage);
            closeStage(bonusStage);
            closeStage(thirdStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        secondaryStage.show();
        return fxmlLoader.<T>getController();
    }
    public static <T> T loadSceneToThirdStage(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("scenes/" + fxml + ".fxml"));

        if (thirdStage == null) {
            thirdStage = new Stage();
        }
        try {
            quizScene = FXMLLoader.load(Main.class.getResource("scenes/QuizSolving.fxml"));
            thirdStage.setScene(new Scene(quizScene));
            thirdStage.setTitle(Main.TITLE);
            thirdStage.setResizable(false);
            closeStage(secondaryStage);
            closeStage(primaryStage);
            closeStage(bonusStage);
        } catch (IOException e) {
            e.printStackTrace();
        }

        thirdStage.show();
        return fxmlLoader.<T>getController();
    }

    public static <T> T loadSceneToBonusStage(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("scenes/" + fxml + ".fxml"));

        if (bonusStage == null) {
            bonusStage = new Stage();
        }
        try {
            bonusScene = FXMLLoader.load(Main.class.getResource("scenes/BonusLevel.fxml"));
            bonusStage.setScene(new Scene(bonusScene));
            bonusStage.setTitle(Main.TITLE);
            bonusStage.setResizable(false);
            closeStage(primaryStage);
            closeStage(secondaryStage);
            closeStage(thirdStage);
        } catch (IOException e) {
            e.printStackTrace();
        }

        bonusStage.show();
        return fxmlLoader.<T>getController();
    }
    public static <T> T loadSceneToRankListStage(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("scenes/" + fxml + ".fxml"));

        if (rankListStage == null) {
            rankListStage = new Stage();
        }
        try {
            rankListScene = FXMLLoader.load(Main.class.getResource("scenes/RankList.fxml"));
            rankListStage.setScene(new Scene(rankListScene));
            rankListStage.setTitle(Main.TITLE);
            rankListStage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        rankListStage.show();
        return fxmlLoader.<T>getController();
    }


    public static void showLogin() {
        loadSceneToPrimaryStage("LoginScreen");
    }
    public static void closeStage(Stage curStage){
        if (curStage != null){
            curStage.close();
        }
    }
}
