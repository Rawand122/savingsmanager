package org.openjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class MainApp extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Money Management");
            stage.setScene(scene);
            stage.getIcons().add(new Image(String.valueOf(getClass().getResource("icon.png"))));
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }


}


