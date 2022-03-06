package org.openjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {


        Label label = new Label();
        label.setText("Hello Rawand, Welcome back!!");
        label.setFont(new Font("Arial\"",15));

        Button expensesBut = new Button();
        Button savingsBut = new Button();
        Button incomeBut = new Button();
        //Setting text to the savingsBut
        expensesBut.setText("Expenses");
        savingsBut.setText("Savings");
        incomeBut.setText("Income");
        //Setting the location of the savingsBut
        savingsBut.setTranslateX(150);
        savingsBut.setTranslateY(60);
        expensesBut.setTranslateY(60);
        expensesBut.setTranslateX(80);
        incomeBut.setTranslateY(60);
        incomeBut.setTranslateX(210);
        //Setting the stage
        Group root = new Group(savingsBut,label,expensesBut,incomeBut);
        Scene scene = new Scene(root, 595, 150, Color.BEIGE);


        //Expenses scene
        Label label2= new Label("This is the Expenses");
        Button button2= new Button("Home");
        button2.setOnAction(e -> stage.setScene(scene));
        VBox layout2= new VBox(20);
        layout2.getChildren().addAll(label2, button2);
        Scene scene2= new Scene(layout2,300,250);

        expensesBut.setOnAction(e -> stage.setScene(scene2));

        //savings scene
        Label label3 = new Label("This is the savings scene");
        Button button3 = new Button("Home");
        button3.setOnAction(e -> stage.setScene(scene));
        VBox layout3 = new VBox(20);
        layout3.getChildren().addAll(label3,button3);

        Scene scene3 = new Scene(layout3,300,250);

        savingsBut.setOnAction(e -> stage.setScene(scene3));

        // Income scene

        Label label4 = new Label("This is the income scene");
        Button button4 = new Button("Home");
        button4.setOnAction(e -> stage.setScene(scene));
        VBox layout4 = new VBox(20);
        layout4.getChildren().addAll(label4,button4);

        Scene scene4 = new Scene(layout4,300,250);

        incomeBut.setOnAction(event -> stage.setScene(scene4));

        stage.setTitle("Savings Manager");
        stage.setScene(scene);


        stage.show();




    }

    public static void main(String[] args) {
        launch(args);
    }

}
