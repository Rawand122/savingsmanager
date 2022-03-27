package org.openjfx;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;


public class MainApp extends Application {


    @Override
    public void start(Stage stage) throws Exception {

  try{

      Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));
      Scene scene = new Scene(root);
      stage.setTitle("Money Management");
      stage.setScene(scene);
      stage.show();



  } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }




}


