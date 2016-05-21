package engine.controllers;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ExceptionHandling{
    public static Stage alertStage;
    private static boolean isCancel;
    private static boolean isConfirm;
    private static final String WARNING = "WARNING";

    public static void warningDisplay(String message){
        alertStage = new Stage();
        alertStage.initModality(Modality.APPLICATION_MODAL);
        alertStage.setTitle(WARNING);
        alertStage.setMinWidth(800);

        Label label = new Label();
        label.setText(message);
        label.setFont(new Font("Arial",20));
        label.setWrapText(true);
        label.setMinHeight(50);

        Button button = new Button("OK");
        button.setOnAction(e -> alertStage.close());
        button.setMinSize(100,20);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,button);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        alertStage.setScene(scene);
        alertStage.showAndWait();
    }
    public static void displayConfirm(String title,String message){
        alertStage = new Stage();
        alertStage.initModality(Modality.APPLICATION_MODAL);
        alertStage.setTitle(title);
        alertStage.setMinWidth(800);
        alertStage.setMinHeight(150);

        Label label = new Label();
        label.setText(message);
        label.setFont(new Font("Arial",20));
        label.setWrapText(true);

        Button okButton = new Button("YES");
        okButton.setMinSize(100,20);
        okButton.setOnAction(ExceptionHandling::isConfirmPressed);

        Button cancelButton = new Button("NO");
        cancelButton.setMinSize(100,20);
        cancelButton.setOnAction(ExceptionHandling::isCancelPressed);

        VBox layout = new VBox(10);
        HBox innerLayout = new HBox(2);
        innerLayout.getChildren().addAll(okButton,cancelButton);
        innerLayout.setAlignment(Pos.CENTER);
        innerLayout.setSpacing(30);
        layout.getChildren().addAll(label,innerLayout);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        alertStage.setScene(scene);
        alertStage.showAndWait();
        if (isCancel()||isConfirm){
            alertStage.close();
        }
    }
    public static boolean isCancel() {
        return isCancel;
    }

    public static boolean isConfirm() {
        return isConfirm;
    }
    private static void setIsConfirm(boolean confirm) {
        isConfirm = confirm;
    }

    private static void setIsCancel(boolean cancel) {
        isCancel = cancel;
    }
    private static void isConfirmPressed(ActionEvent actionEvent){
        setIsConfirm(true);
        alertStage.close();
    }
    private static void isCancelPressed(ActionEvent actionEvent){
        setIsCancel(true);
        alertStage.close();
    }
}
