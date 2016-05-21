package engine;

import engine.controllers.ExceptionHandling;
import engine.controllers.ScreenController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import static engine.controllers.ExceptionHandling.displayConfirm;

public class Main extends Application {
    public static final String TITLE = "Java Quiz";

    @Override
    public void start(Stage primaryStage) throws Exception {
        ScreenController.setPrimaryStage(primaryStage);
        ScreenController.showLogin();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) {
                displayConfirm("EXIT","Do you want to exit?");
                if (ExceptionHandling.isCancel()){
                    event.consume();
                } else if (ExceptionHandling.isConfirm()){
                    primaryStage.close();
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
